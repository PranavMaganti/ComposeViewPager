# ViewPager for Jetpack Compose (WIP)

**Current Compose Version: dev16**

## Download

 [ ![Download](https://api.bintray.com/packages/vanpra/maven/compose-viewpager%3Aviewpager/images/download.svg) ](https://bintray.com/vanpra/maven/compose-viewpager%3Aviewpager/_latestVersion)

```kotlin
dependencies {
  ...
  implementation 'com.vanpra.compose-viewpager:viewpager:0.1.2'
  ...
}
```

## Usage

```kotlin
ViewPager(Modifier.fillMaxSize()) {
    Box(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        backgroundColor = Color.Blue
    ) {
        Text("Index: $index", Modifier.padding(8.dp))

        Row {
            TextButton(
                onClick = { previous() },
                modifier = Modifier.padding(8.dp),
                backgroundColor = Color.Red
            ) {
                Text("Previous", color = Color.White)
            }

            TextButton(
                onClick = { next() },
                modifier = Modifier.padding(8.dp),
                backgroundColor = Color.Red
            ) {
                Text("Next", color = Color.White)
            }
        }
    }
}
```



All children of a the ViewPager composable  have access to the attributes of the ViewPager scope. Currently you can access the `index` variable which is the page number which should be composed, a `next()` method which will animate the ViewPager to the next page and a `previous` method which will animate the ViewPager to the previous page. 

 

## To Do

1. Finish implementing custom transitions API
2. Clean up code