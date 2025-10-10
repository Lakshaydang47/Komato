package com.devdroid.komato.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
// Removed ExperimentalMaterialApi and the M2 FilterChip import
// import androidx.compose.material.ExperimentalMaterialApi // <-- REMOVED
// import androidx.compose.material.FilterChip // <-- REMOVED
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text // Changed from M2 Text to M3 Text
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip // <-- USING M3 FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Removed @OptIn(ExperimentalMaterialApi::class) since we're using M3 FilterChip
@Composable
fun FiltersRow(filters: List<String>) {
    var selectedFilter by remember { mutableStateOf<String?>(null) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        // Filter chips
        LazyRow(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items (filters) { filter ->
                FilterChip(
                    // Toggle selection logic
                    onClick = {selectedFilter = if (selectedFilter == filter) null else filter },
                    colors = FilterChipDefaults.filterChipColors(
                        // Use selectedContainerColor and selectedLabelColor for better M3 style
                        selectedContainerColor = colorResource(R.color.teal_200).copy(alpha = 0.2f),
                        containerColor = Color.White,
                        labelColor = Color.DarkGray,
                        selectedLabelColor = colorResource(R.color.teal_200)
                    ),
                    selected = selectedFilter == filter,

                    // Fixed 'enabled = true'
                    enabled = true,

                    // M3 FilterChip uses 'border' as a parameter (not a slot)
                    border = BorderStroke(
                        0.4.dp,
                        color = if (selectedFilter == filter) colorResource(R.color.teal_200) else Color.LightGray
                    ),

                    // M3 FilterChip uses 'label' for the main content
                    label = {Text(filter, fontSize = 12.sp)},

                    // M3 FilterChip uses 'leadingIcon' as a trailing lambda
                    leadingIcon = {
                        if (filter == "Filter") {
                            Icon(
                                painter = painterResource(id = R.drawable.dining) ,
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        if (filter == "Flash Sale") {
                            Icon(
                                painter = painterResource(id = R.drawable.snack_meal),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        if (filter == "Under 30 mins") {
                            Icon(
                                painter = painterResource(id = R.drawable.timer),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        // Corrected "RAting" to "Rating"
                        if (filter == "Rating") {
                            Icon(
                                painter = painterResource(id = R.drawable.rating),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        if (filter == "Schedule") {
                            Icon(
                                painter = painterResource(id = R.drawable.notes),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    },

                    // M3 FilterChip uses 'trailingIcon' as a trailing lambda
                    trailingIcon = {
                        if (filter == "Filter"){
                            Icon(
                                painter = painterResource(R.drawable.arrowdown),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        // Display close icon only when selected and not the "Filter" chip
                        if (selectedFilter == filter && filter != "Filter") {
                            Icon(
                                painter = painterResource(R.drawable.close),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    },
                )
            }
        }
    }
}