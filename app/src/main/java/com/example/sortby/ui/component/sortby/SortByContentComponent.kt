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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    padding: PaddingValues,
    scrollState: LazyListState,
    contacts: List<Contact>,
) {
    Column(modifier.padding(16.dp)) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)) {
            Column(modifier.weight(1f)) {
                Text(text = "Offers")
            }
            Column(modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Icon(painter = painterResource(id = R.drawable.ic_newest), contentDescription = "")
            }
        }
        LazyColumn(
            modifier.fillMaxSize(),
            state = scrollState,
            contentPadding = padding
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
    SortByContentComponent(
        contacts = contact,
        padding = PaddingValues(),
        scrollState = LazyListState()
    )
}
