package com.example.sortby.ui.component.sortby

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sortby.R
import com.example.sortby.models.data.Contact
import com.example.sortby.models.empty.contact
import com.example.sortby.ui.component.list.ContactItem

@Composable
fun SortByContentComponent(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp),
    scrollState: LazyListState,
    contacts: List<Contact>,
    onIconClick: () -> Unit,
    sortByComponentState: MutableState<Boolean>
) {
    Column(
        modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier
                    .weight(1f)
                    .padding(top = 16.dp)) {
                Text(text = "Offers", color = Color.Black)
            }
            Column(modifier.weight(1f), horizontalAlignment = Alignment.End) {
                IconButton(
                    onClick = {
                        onIconClick()
                        sortByComponentState.value = true
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_newest),
                        contentDescription = ""
                    )
                }
            }
        }
        LazyColumn(
            modifier.fillMaxSize(),
            state = scrollState
        ) {
            items(contacts) { contact ->
                ContactItem(contact = contact)
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun SortByContentComponentPreview() {
    val sortByComponentState = remember { mutableStateOf(false) }

    SortByContentComponent(
        contacts = contact,
        padding = PaddingValues(16.dp),
        scrollState = LazyListState(),
        onIconClick = {},
        sortByComponentState = sortByComponentState
    )
}

