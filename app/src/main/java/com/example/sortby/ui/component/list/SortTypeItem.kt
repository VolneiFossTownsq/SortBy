package com.example.sortby.ui.component.list

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sortby.R
import com.example.sortby.models.data.SortByItem
import com.example.sortby.models.empty.sortTypes

@Composable
fun SortTypeItem(sortType: SortByItem) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
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

@Preview(showSystemUi = true)
@Composable
fun SortTypeItemPreview() {
    SortTypeItem(sortType = sortTypes.first())
}