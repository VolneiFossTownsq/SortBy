package com.example.sortby.ui.component.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sortby.models.data.SortByItem
import com.example.sortby.models.empty.sortTypes

@Composable
fun SortTypeItem(sortType: SortByItem, onItemClick: () -> Unit) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { onItemClick() }
        ) {
            Column(
                Modifier
                    .weight(0.1f)
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = sortType.icon),
                    contentDescription = ""
                )
            }
            Column(
                Modifier
                    .weight(0.9f)
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = sortType.name)
            }
        }
        Divider(
            Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color(0xFFE6E6E6),
        )
    }
}
