package com.vanpra.composeviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp
import com.vanpra.viewpager.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                ViewPager(Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize(), backgroundColor = Color.Blue) {
                        Text("Index: $index", Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}