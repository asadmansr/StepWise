package com.asadmansr.stepwise.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.asadmansr.stepwise.components.home.HomeScreen
import com.asadmansr.stepwise.components.settings.SettingScreen


@Composable
fun MainNavigation() {
    val backStack = remember { mutableStateListOf<NavigationRoute>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = entryProvider {
            entry<Home> { entry ->
                HomeScreen(
                    onSettingsTapped = {
                        backStack.add(Settings)
                    },
                )
            }
            entry<Settings> { entry ->
                SettingScreen(
                    onBackPressed = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}