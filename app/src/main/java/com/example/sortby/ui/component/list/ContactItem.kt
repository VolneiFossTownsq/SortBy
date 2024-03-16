package com.example.sortby.ui.component.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sortby.models.data.Contact
import com.example.sortby.models.empty.contact

@Composable
fun ContactItem(modifier: Modifier = Modifier, contact: Contact) {
    Row(modifier.fillMaxWidth()
        .padding(bottom = 16.dp)) {
        Column() {
            Icon(Icons.Filled.Person, contentDescription = "", modifier.size(32.dp))
        }
        Column(
            modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = contact.name, fontSize = 22.sp)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun ContactItemPreview() {
    ContactItem(contact = contact.first())
}