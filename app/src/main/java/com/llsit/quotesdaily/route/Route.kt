package com.llsit.quotesdaily.route

import kotlinx.serialization.Serializable

sealed interface Route { val path: String
    @Serializable
    data object Home : Route { override val path = "home" }
    @Serializable
    data object Fav : Route { override val path = "fav" }
    @Serializable
    data object Topics : Route { override val path = "topics" }
    @Serializable
    data object Settings : Route { override val path = "settings" }
}


val primaryDestinations = listOf(Route.Home, Route.Fav, Route.Topics)