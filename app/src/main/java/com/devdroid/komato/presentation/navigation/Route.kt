package com.devdroid.komato.presentation.navigation

import kotlinx.serialization.Serializable
import okhttp3.Route

sealed class SubNavigation {
    @Serializable
    object LoginSignUpScreen : SubNavigation()

    @Serializable
    object MainHomeScreen : SubNavigation()

}

sealed class Routes {

    @Serializable
    object LogInScreen : Routes()

    @Serializable
    object SignUpScreen : Routes()

    @Serializable
    object DeliveryScreen : Routes()

    @Serializable
    object QuickScreen : Routes()

    @Serializable
    object DiningScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    object ParticularCardScreen : Routes()

    @Serializable
    object FinalCheckoutScreen : Routes()

    @Serializable
    object ScreachBarScreen : Routes()




}