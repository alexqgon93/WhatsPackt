package com.alexesquerdo.whatspackt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.alexesquerdo.whatspackt.ui.navigation.MainNavigation
import com.alexesquerdo.whatspackt.ui.theme.WhatsPacktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsPacktTheme {
                val navHostController = rememberNavController()
                MainNavigation(navController = navHostController)
            }
        }
    }
}
