package com.llsit.quotesdaily

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.llsit.quotesdaily.ui.theme.QuotesDailyTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Hello World",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotesDailyTheme {
        HomeScreen()
    }
}