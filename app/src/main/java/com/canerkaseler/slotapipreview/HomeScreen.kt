package com.canerkaseler.slotapipreview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        MessageCard(
            modifier = Modifier
                .size(size = 300.dp),
            icon = R.drawable.wifi_error,
            title = "Connection Problem",
            description = "There is an internet connection error.",
            positiveButtonText = "Report an issue",
            negativeButtonText = "Cancel",
            onClickPositiveButton = {},
            onClickNegativeButton = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
    )
}
