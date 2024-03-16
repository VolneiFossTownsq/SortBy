package com.example.sortby.ui.component.sortby

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sortby.models.data.SortByItem
import com.example.sortby.models.empty.sortTypes
import com.example.sortby.ui.component.list.SortTypeItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortByComponent(
    sortTypes: List<SortByItem>,
    onSortTypeSelected: (SortByItem) -> Unit,
    onDismissRequest: () -> Unit,
    onItemClick: (SortByItem) -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = bottomSheetState,
        shape = BottomSheetDefaults.HiddenShape,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Sort by")
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        items(sortTypes) { sortType ->
                            SortTypeItem(sortType, onItemClick = {
                                onSortTypeSelected(sortType)
                                onItemClick(sortType)
                            })
                        }
                    }
                }
            }
        },
        onDismissRequest = onDismissRequest
    )
}



