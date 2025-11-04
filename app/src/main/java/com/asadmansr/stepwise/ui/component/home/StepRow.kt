package com.asadmansr.stepwise.ui.component.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asadmansr.stepwise.data.model.Step
import com.asadmansr.stepwise.ui.theme.DeepPink
import com.asadmansr.stepwise.ui.theme.FredokaFontFamily
import com.asadmansr.stepwise.ui.theme.SkyBlue
import com.asadmansr.stepwise.ui.theme.White

@Composable
fun StepRow(
    steps: List<Step>,
    onStepTapped: (step: Step) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
                bottom = 24.dp
            )
    ) {
        items(steps) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 16.dp
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable{
                            onStepTapped(it)
                        }
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp,
                            start = 24.dp,
                            end = 24.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = it.date,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontFamily = FredokaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = DeepPink
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = it.steps.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontFamily = FredokaFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = SkyBlue
                    )
                }
            }
        }
    }
}
