package com.canerkaseler.slotapipreview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    errorType: ErrorType = ErrorType.CONNECTION,
    modifier: Modifier = Modifier,
    generalMessageData: MessageCardSlot.Parameters,
    batteryMessageData: MessageCardSlot.Parameters,
    connectionMessageData: MessageCardSlot.Parameters,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when(errorType) {
            ErrorType.GENERAL -> {
                MessageCard(
                    messageData = generalMessageData,
                )
            }
            ErrorType.BATTERY -> {
                MessageCard(
                    messageData = batteryMessageData,
                )
            }
            ErrorType.CONNECTION -> {
                MessageCard(
                    messageData = connectionMessageData,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    HomeScreen(
        errorType = ErrorType.BATTERY,
        modifier = Modifier
            .fillMaxSize(),
        generalMessageData = MessageCardSlot.Parameters(
            icon = R.drawable.general_error,
            title = "Application Problem",
            description = "You can inform to us about it.",
            positiveButtonText = "Send an e-mail",
            negativeButtonText = "Close",
            onClickPositiveButton = {},
            onClickNegativeButton = {},
        ),
        batteryMessageData = MessageCardSlot.Parameters(
            icon = R.drawable.battery_error,
            title = "Battery Problem",
            description = "There is an battery error.",
            positiveButtonText = "Check battery",
            negativeButtonText = "Close",
            onClickPositiveButton = {},
            onClickNegativeButton = {},
        ),
        connectionMessageData = MessageCardSlot.Parameters(
            icon = R.drawable.wifi_error,
            title = "Connection Problem",
            description = "There is an internet connection error.",
            positiveButtonText = "Report an issue",
            negativeButtonText = "Cancel",
            onClickPositiveButton = {},
            onClickNegativeButton = {},
        )
    )
}
