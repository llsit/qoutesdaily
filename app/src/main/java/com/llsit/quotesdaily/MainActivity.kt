package com.llsit.quotesdaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.llsit.quotesdaily.route.Route
import com.llsit.quotesdaily.ui.theme.QuotesDailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesDailyTheme {
                QuotesNavHost()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun QuotesNavHost() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daily Quotes") },
                actions = { /* search or quick actions */ }
            )
        }
    ) { innerPadding ->
        NavigationRoot(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun NavigationRoot(modifier: Modifier) {
    val backStack = remember { mutableStateListOf<Route>(Route.Home) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                Route.Fav -> NavEntry(key) {
                    Text("Fav")
                }

                Route.Home -> NavEntry(key) {
                    HomeScreen(modifier)
                }

                Route.Settings -> NavEntry(key) {
                    Text("Settings")
                }

                Route.Topics -> NavEntry(key) {
                    Text("Topics ")
                }
            }
        }
    )
}

