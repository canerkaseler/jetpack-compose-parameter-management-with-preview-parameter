package com.canerkaseler.slotapipreview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.canerkaseler.slotapipreview.ui.theme.SlotApiPreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlotApiPreviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        generalMessageData = MessageCardSlot.Parameters(
                            icon = R.drawable.general_error,
                            title = "Application Problem",
                            description = "You can inform to us about it.",
                            positiveButton = MessageCardSlot.ParametersPositiveButton(
                                text = "Send an e-mail",
                                onClick = {},
                            ),
                            negativeButton = MessageCardSlot.ParametersNegativeButton(
                                text = "Close",
                                onClick = {},
                            ),
                        ),
                        batteryMessageData = MessageCardSlot.Parameters(
                            icon = R.drawable.battery_error,
                            title = "Battery Problem",
                            description = "There is an battery error.",
                            positiveButton = MessageCardSlot.ParametersPositiveButton(
                                text = "Check battery",
                                onClick = {},
                            ),
                            negativeButton = MessageCardSlot.ParametersNegativeButton(
                                text = "Close",
                                onClick = {},
                            ),
                        ),
                        connectionMessageData = MessageCardSlot.Parameters(
                            icon = R.drawable.wifi_error,
                            title = "Connection Problem",
                            description = "There is an internet connection error.",
                            positiveButton = MessageCardSlot.ParametersPositiveButton(
                                text = "Report an issue",
                                onClick = {},
                            ),
                            negativeButton = MessageCardSlot.ParametersNegativeButton(
                                text = "Close",
                                onClick = {},
                            ),
                        )
                    )
                }
            }
        }
    }
}