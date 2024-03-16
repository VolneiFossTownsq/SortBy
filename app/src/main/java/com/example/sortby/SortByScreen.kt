package com.example.sortby

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.sortby.models.empty.contact
import com.example.sortby.models.empty.sortTypes
import com.example.sortby.ui.component.sortby.SortByComponent
import com.example.sortby.ui.component.sortby.SortByContentComponent
import com.example.sortby.ui.theme.SortByTheme

class SortByScreen : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SortByTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OfferSortByScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OfferSortByScreen() {
    val sortByComponentState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            SortByContentComponent(
                scrollState = LazyListState(),
                padding = it,
                contacts = contact,
                onIconClick = {},
                sortByComponentState = sortByComponentState
            )
        },
        bottomBar = {
            if (sortByComponentState.value) {
                SortByComponent(
                    sortTypes = sortTypes,
                    onSortTypeSelected = { /* lógica de seleção */ },
                    onDismissRequest = { sortByComponentState.value = false },
                    onItemClick = { /* lógica de clique no item */ }
                )
            }
        }
    )
}


