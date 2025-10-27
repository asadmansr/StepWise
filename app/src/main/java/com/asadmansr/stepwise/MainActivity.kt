package com.asadmansr.stepwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.asadmansr.stepwise.navigation.MainNavigation
import com.asadmansr.stepwise.ui.theme.StepWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepWiseTheme {
                MainNavigation()
            }
        }
    }
}
