package com.smartherd.capstonelittlelemonapp.navigation

interface Destinations{
    val route: String
}

object Onboarding: Destinations{
    override val route = "Onboarding"
}

object Home: Destinations{
    override val route = "Home"
}

object Profile: Destinations{
    override val route = "Profile"
}

object Test: Destinations{
    override val route = "Test"
}