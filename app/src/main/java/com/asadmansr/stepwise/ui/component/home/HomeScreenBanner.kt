package com.asadmansr.stepwise.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asadmansr.stepwise.ui.theme.DarkGray
import com.asadmansr.stepwise.ui.theme.DeepPink
import com.asadmansr.stepwise.ui.theme.FredokaFontFamily
import com.asadmansr.stepwise.ui.theme.White

@Composable
fun HomeScreenBanner() {
    Column(
        modifier = Modifier
            .padding(start = 28.dp, top = 12.dp)
            .rotate(-10f)
            .background(
                color = White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Today",
            fontSize = 12.sp,
            fontFamily = FredokaFontFamily,
            fontWeight = FontWeight.Normal,
            color = DarkGray

        )
        Text(
            text = "8,120",
            fontSize = 28.sp,
            lineHeight = 10.sp,
            fontFamily = FredokaFontFamily,
            fontWeight = FontWeight.Normal,
            color = DeepPink
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun HomeScreenBannerPreview() {
    HomeScreenBanner()
}
