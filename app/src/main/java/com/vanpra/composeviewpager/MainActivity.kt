package com.vanpra.composeviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.unit.dp
import com.vanpra.viewpager.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
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
            }
        }
    }
}
