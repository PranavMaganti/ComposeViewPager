package com.vanpra.composeviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.vanpra.composeviewpager.ui.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ViewPager(Modifier.fillMaxSize(), transition = ViewPagerTransition.ZOOM_OUT) {
                    Box(modifier = Modifier.fillMaxSize(), backgroundColor = Color.Blue) {
                        Text("Index: $index", Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}