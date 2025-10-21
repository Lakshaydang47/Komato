package com.devdroid.komato.presentation.screens.CategoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devdroid.komato.presentation.components.ExploreRow
import com.devdroid.komato.presentation.components.HomeScreenCard

@Composable
fun AllCategoryScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        ExploreRow()
        Row(
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, top = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Column {
                Text(
                    text = "535 RESTAURANTS DELIVERING TO YOU",
                    modifier = Modifier,
                    color = Color.Gray
                )
                Text(
                    text = "Featured",
                    modifier = Modifier.padding(start = 5.dp),
                    color = Color.Gray

                )
            }
        }

        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
    }

}



