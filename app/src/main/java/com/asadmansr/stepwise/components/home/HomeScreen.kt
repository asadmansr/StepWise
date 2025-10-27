package com.asadmansr.stepwise.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.asadmansr.stepwise.ui.theme.OrangeBackground
import com.asadmansr.stepwise.ui.theme.PinkBackground

@Composable
fun HomeScreen(
    onSettingsTapped: () -> Unit = {}
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(OrangeBackground, PinkBackground)
                    )
                )
                .padding(innerPadding)
        ) {
            HomeScreenHeader(onSettingsTapped)
            HomeScreenBanner()
        }
    }
}
