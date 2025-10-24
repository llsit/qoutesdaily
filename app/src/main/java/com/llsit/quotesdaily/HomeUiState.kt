package com.llsit.quotesdaily

data class HomeUiState(
    val isLoading: Boolean = false,
    val quoteText: String = "",
    val author: String? = null,
    val topic: String? = null,
    val isFavorite: Boolean = false,
    val isOffline: Boolean = false,
    val error: String? = null
)