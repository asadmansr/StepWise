package com.asadmansr.stepwise.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute

@Serializable
data object Home : NavigationRoute

@Serializable
data object Settings : NavigationRoute
