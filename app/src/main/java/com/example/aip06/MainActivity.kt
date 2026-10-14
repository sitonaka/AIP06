package com.example.aip06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aip06.ui.dashboard.DashboardScreen
import com.example.aip06.ui.theme.AIP06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AIP06Theme {
                DashboardScreen()
            }
        }
    }
}
