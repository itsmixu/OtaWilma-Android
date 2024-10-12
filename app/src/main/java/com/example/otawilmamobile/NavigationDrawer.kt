package com.example.otawilmamobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .padding(top = 48.dp),
        contentAlignment = Alignment.BottomStart

    ){
        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(R.drawable.baseline_deblur_24),
                colorFilter = ColorFilter.tint(Color.Cyan),
                contentDescription = "OtaWilma Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(end = 12.dp)
            )
            Text(
                text = "OtaWilma",
                fontSize = 22.sp
            )
        }
    }
}


@Composable
fun DrawerBody(
    items: List<MenuItem>,
    infoItem: MenuItem,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()){
        LazyColumn(modifier) {
            items(items) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(16.dp)

                ){
                    Icon(imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.title,
                        style = itemTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clickable {
                    onItemClick(infoItem)
                }
                .padding(16.dp)
        ){
            Icon(imageVector = infoItem.icon,
                contentDescription = infoItem.contentDescription
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = infoItem.title,
                style = itemTextStyle,
                modifier = Modifier.weight(1f)
            )
        }
    }
}