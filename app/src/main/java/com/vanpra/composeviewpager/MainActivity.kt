package com.vanpra.composeviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.unit.dp
import com.vanpra.viewpager.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Box(backgroundColor = Color.Red) {
                    ViewPager(range = IntRange(0, 1)) {
                        val modifier = when(index % 4) {
                            0 -> Modifier.height(100.dp)
                            1 -> Modifier.height(200.dp)
                            2 -> Modifier.height(300.dp)
                            else -> Modifier.height(400.dp)
                        }

                        Box(
                            modifier = Modifier.fillMaxWidth().padding(8.dp).plus(modifier),
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
