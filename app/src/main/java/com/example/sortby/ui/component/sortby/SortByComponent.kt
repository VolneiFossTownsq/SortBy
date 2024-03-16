package com.example.sortby.ui.component.sortby

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    scrollState: LazyListState,
    isEdgeToEdgeEnabled: Boolean = false,
    isSkipPartiallyExpanded: Boolean = false,
    isOpenBottomSheet: Boolean = false
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(isOpenBottomSheet) }
    val edgeToEdgeEnabled by remember { mutableStateOf(isEdgeToEdgeEnabled) }
    val skipPartiallyExpanded by remember { mutableStateOf(isSkipPartiallyExpanded) }
    val windowInsets = if (edgeToEdgeEnabled) WindowInsets(0) else BottomSheetDefaults.windowInsets
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )

    ModalBottomSheet(
        onDismissRequest = { openBottomSheet = false },
        sheetState = bottomSheetState,
        windowInsets = windowInsets
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Sort by")
        }
        LazyColumn(
            Modifier.fillMaxSize(),
            state = scrollState,
        ) {
            items(sortTypes) { sortType ->
                SortTypeItem(sortType)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SortByComponentPreview() {
    SortByComponent(
        sortTypes = sortTypes,
        scrollState = LazyListState(),
        isOpenBottomSheet = true
    )
}
