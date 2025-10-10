package com.devdroid.komato.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devdroid.komato.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiningSearchBar (navController: NavController) {
    var query by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .shadow(2.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, color = colorResource(R.color.black), RoundedCornerShape(16.dp))
            .clickable {
//                navController.navigate(Routes.SearchBarScreen)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp)) // Adjust spacing from start

        Icon(
            Icons.Default.Search,
            tint = colorResource(R.color.teal_200),
            contentDescription = "Search Icon",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text field
        BasicTextField(
            value = query,
            onValueChange = { query = it },
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Gray
            ),
            enabled = false,
            singleLine = true,
            modifier = Modifier
                .padding(vertical = 12.dp),
            decorationBox = { innerTextField ->
                if (query.isEmpty()) {
                    Text(
                        "Search Restaurant",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        )
        Spacer(modifier = Modifier.width (8.dp)) // Space between text field and icon
        Icon(
            painter = painterResource(R.drawable.mic),
            contentDescription = "Voice Search",
            tint = colorResource(R.color.teal_200),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp)) // Adjust spacing from end
    }
}
