package com.devdroid.komato.presentation.screens.CategoryScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PizzaCategoryScreen(navController: NavController) {
    ChineseCategoryCards(navController = navController)
}