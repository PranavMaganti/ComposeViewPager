# ViewPager for Jetpack Compose

## Download

[ ![Download](https://api.bintray.com/packages/vanpra/ComposeViewPager/composeviewpager/images/download.svg?version=0.1.0) ](https://bintray.com/vanpra/ComposeViewPager/composeviewpager/0.1.0/link)

```kotlin
dependencies {
  ...
  implementation 'com.vanpra:composeviewpager:0.1.0'
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
                modifier = Modifier.gravity(Alignment.Start).padding(8.dp),
                backgroundColor = Color.Red
            ) {
                Text("Previous", color = Color.White)
            }

            TextButton(
                onClick = { next() },
                modifier = Modifier.gravity(Alignment.End).padding(8.dp),
                backgroundColor = Color.Red
            ) {
                Text("Next", color = Color.White)
            }
        }
    }
}
```



All children of a the ViewPager composable  have access to the attributes of the ViewPager scope. Currently you can access the `index` variable which is the page number which should be composed, a `next()` method which will animate the ViewPager to the next page and a `previous` method which will animate the ViewPager to the previous page. 

 