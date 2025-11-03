package com.asadmansr.stepwise.ui.component.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asadmansr.stepwise.ui.theme.FredokaFontFamily
import com.asadmansr.stepwise.ui.theme.White

@Composable
fun HomeScreenHeader(
    onSettingsTapped: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(
                start = 24.dp,
                top = 16.dp,
                bottom = 16.dp
            ),
            text = "My Steps",
            color = White,
            fontFamily = FredokaFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            modifier = Modifier.padding(end = 8.dp),
            onClick = onSettingsTapped
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.Rounded.Settings,
                contentDescription = "App settings",
                tint = White
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun HomeScreenHeaderPreview() {
    HomeScreenHeader(
        onSettingsTapped = {}
    )
}
