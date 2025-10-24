package com.llsit.quotesdaily

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llsit.quotesdaily.ui.theme.QuotesDailyTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        QuoteContent(HomeUiState(), {}, {}, {})
    }
}

@Composable
private fun QuoteContent(
    state: HomeUiState,
    onToggleFav: () -> Unit,
    onShare: () -> Unit,
    onChangeTopic: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AssistChip(onClick = { /* show day picker */ }, label = { Text("Today") })
            Spacer(Modifier.width(8.dp))
            state.topic?.let { AssistChip(onClick = onChangeTopic, label = { Text(it) }) }
            if (state.isOffline) {
                Spacer(Modifier.width(8.dp))
                AssistChip(onClick = {}, enabled = false, label = { Text("Offline") })
            }
        }
        Spacer(Modifier.height(24.dp))
        Crossfade(targetState = state.quoteText) { text ->
            Text(
                text = "\u275D " + text + " \u275E",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = state.author?.let { "— $it" } ?: "",
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            FilledTonalButton(onClick = onToggleFav) {
                Icon(
                    if (state.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    null
                )
                Spacer(Modifier.width(8.dp))
                Text(if (state.isFavorite) "Unfavorite" else "Favorite")
            }
            Spacer(Modifier.width(12.dp))
            Button(onClick = onShare) {
                Icon(
                    Icons.Default.Share,
                    null
                ); Spacer(Modifier.width(8.dp)); Text("Share")
            }
            Spacer(Modifier.width(12.dp))
            OutlinedButton(onClick = onChangeTopic) {
                Icon(
                    Icons.Default.Tag,
                    null
                ); Spacer(Modifier.width(8.dp)); Text("Change Topic")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotesDailyTheme {
        HomeScreen()
    }
}