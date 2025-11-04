package com.asadmansr.stepwise.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.asadmansr.stepwise.ui.theme.DarkGray
import com.asadmansr.stepwise.ui.theme.EmeraldGreen
import com.asadmansr.stepwise.ui.theme.Graphite
import com.asadmansr.stepwise.ui.theme.White

@Composable
fun AddStep(
    onStepAdd: (step: Int) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val stepText = rememberTextFieldState()

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Graphite,
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
            )
            .padding(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                state = stepText,
                lineLimits = TextFieldLineLimits.SingleLine,
                label = { Text("Steps") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Graphite,
                    unfocusedContainerColor = Graphite,
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedLabelColor = DarkGray,
                    unfocusedLabelColor = DarkGray,
                    cursorColor = White,
                    focusedIndicatorColor = Graphite,
                    unfocusedIndicatorColor = Graphite

                ),
                modifier = Modifier.focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                inputTransformation = InputTransformation.maxLength(5).then {
                    if (!this.asCharSequence().isDigitsOnly()) {
                        revertAllChanges()
                    }
                },
            )

            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = EmeraldGreen,
                    contentColor = White
                ),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    onStepAdd(stepText.text.toString().toInt())
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Add new step"
                )
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp))
        }
    }
}
