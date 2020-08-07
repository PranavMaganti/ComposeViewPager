package com.vanpra.composeviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.vanpra.viewpager.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Box(backgroundColor = Color.Red, modifier = Modifier.fillMaxSize()) {
                    ViewPager(range = IntRange(0, Int.MAX_VALUE)) {
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
                }
            }
        }
    }
}
