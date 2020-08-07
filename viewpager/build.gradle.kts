import java.util.Date

plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
    id("com.jfrog.bintray")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.1"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "0.1.0-dev16"
        kotlinCompilerVersion = "1.4.0-rc"
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")

    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check")
    }
}

dependencies {
    val composeVersion = "0.1.0-dev16"

    implementation(kotlin("stdlib-jdk8"))
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")

    implementation("com.google.android.material:material:1.2.0")

    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")

    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

val artifactName = "core"
val artifactGroup = "com.vanpra.compose-viewpager"
val artifactVersion = "0.1.2"

val sourcesJar by tasks.creating(Jar::class) {
    from(android.sourceSets.getByName("main").java.srcDirs)
    archiveClassifier.set("sources")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components.getByName("release"))
                artifact(sourcesJar)

                groupId = artifactGroup
                artifactId = artifactName
                version = artifactVersion
            }
        }
    }

    bintray {
        user = project.findProperty("bintrayUser").toString()
        key = project.findProperty("bintrayKey").toString()
        publish = false
        override = true

        setPublications("release")

        pkg.apply {
            repo = "maven"
            name = "compose-viewpager:$artifactName"

            version.apply {
                name = artifactVersion
                released = Date().toString()
                vcsTag = artifactVersion
            }
        }
    }
}