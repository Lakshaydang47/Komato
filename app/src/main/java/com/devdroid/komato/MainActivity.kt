package com.devdroid.komato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.devdroid.komato.presentation.components.DiningScreenContent
import com.devdroid.komato.presentation.components.TopAppBarDiningScreen
import com.devdroid.komato.presentation.navigation.App
import com.devdroid.komato.presentation.screens.CategoryScreen.AllCategoryScreen
import com.devdroid.komato.presentation.screens.DeliveryScreen
import com.devdroid.komato.presentation.screens.DiningScreen
import com.devdroid.komato.presentation.utils.SearchBarDiningTabScreen
import com.devdroid.komato.ui.theme.KomatoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KomatoTheme {
                val navController = rememberNavController()
                val listState = rememberLazyListState()
                DiningScreen(navController, listState)
            }
        }
    }
}


