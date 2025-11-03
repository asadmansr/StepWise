package com.asadmansr.stepwise.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asadmansr.stepwise.data.model.HomeScreenEvent
import com.asadmansr.stepwise.ui.component.home.AddStep
import com.asadmansr.stepwise.ui.component.home.HomeScreenBanner
import com.asadmansr.stepwise.ui.component.home.HomeScreenHeader
import com.asadmansr.stepwise.ui.theme.Graphite
import com.asadmansr.stepwise.ui.theme.LightViolet
import com.asadmansr.stepwise.ui.theme.OrangeBackground
import com.asadmansr.stepwise.ui.theme.PinkBackground

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onSettingsTapped: () -> Unit = {}
) {
    var isAddStepToggled by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            if (!isAddStepToggled) {
                FloatingActionButton(
                    onClick = {
                        isAddStepToggled = true
                    },
                    containerColor = LightViolet,
                    contentColor = Graphite
                ) {
                    Icon(Icons.Rounded.Add, "Add new steps.")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(OrangeBackground, PinkBackground)
                        )
                    )
                    .clickable {
                        isAddStepToggled = false
                    }
                    .padding(innerPadding)
            ) {
                HomeScreenHeader(onSettingsTapped)
                HomeScreenBanner()
            }

            if (isAddStepToggled) {
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = innerPadding.calculateBottomPadding())
                ) {
                    AddStep(
                        onStepAdd = {
                            homeViewModel.handleEvent(HomeScreenEvent.OnAddStep(it))
                        }
                    )
                }
            }
        }
    }
}
