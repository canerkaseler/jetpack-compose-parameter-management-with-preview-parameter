package com.canerkaseler.slotapipreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    errorType: ErrorType = ErrorType.CONNECTION,
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

sealed interface HomeScreenSlot {
    data class Parameters(
        val errorType: ErrorType,
        val generalMessageData: MessageCardSlot.Parameters,
        val batteryMessageData: MessageCardSlot.Parameters,
        val connectionMessageData: MessageCardSlot.Parameters,
    )
}

private val fakeHomeScreenParameters =
    HomeScreenSlot.Parameters(
        errorType = ErrorType.CONNECTION,
        generalMessageData = fakeGeneralErrorParameters,
        batteryMessageData = fakeBatteryErrorMessageParameters,
        connectionMessageData = fakeConnectionErrorMessageParameters,
    )


private fun interface HomeScreenPreviewData {
    @Composable
    fun value(): HomeScreenSlot.Parameters
}

private fun fakeHomeScreenState(
    parameters: HomeScreenSlot.Parameters
) = HomeScreenPreviewData(
    function = {
        parameters
    }
)

private val fakeErrorMessageStateList = listOf (
    fakeHomeScreenState(parameters = fakeHomeScreenParameters), // Default is ErrorType.CONNECTION.
    fakeHomeScreenState(parameters = fakeHomeScreenParameters.copy(errorType = ErrorType.GENERAL)),
    fakeHomeScreenState(parameters = fakeHomeScreenParameters.copy(errorType = ErrorType.BATTERY)),
    fakeHomeScreenState(parameters = fakeHomeScreenParameters.copy(
        connectionMessageData = fakeHomeScreenParameters.connectionMessageData.copy(
            icon = R.drawable.money,
            title = "Low balance for Internet"
        )
    )),
    fakeHomeScreenState(parameters = fakeHomeScreenParameters.copy(
        errorType = ErrorType.BATTERY,
        batteryMessageData = fakeHomeScreenParameters.batteryMessageData.copy(
            icon = R.drawable.fire,
            title = "Need a new battery"
        )
    )),
    fakeHomeScreenState(parameters = fakeHomeScreenParameters.copy(
        errorType = ErrorType.GENERAL,
        generalMessageData = fakeHomeScreenParameters.generalMessageData.copy(
            icon = R.drawable.bug,
            title = "If you see something, say something"
        )
    )),
)

private class HomeScreenPreviewProvider : PreviewParameterProvider<HomeScreenPreviewData> {
    override val values = fakeErrorMessageStateList.asSequence()
}

@Preview(showBackground = true)
@Composable
private fun Preview(
    @PreviewParameter(HomeScreenPreviewProvider::class) homeScreenPreviewData: HomeScreenPreviewData,
){
    HomeScreen(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize(),
        errorType = homeScreenPreviewData.value().errorType,
        generalMessageData = homeScreenPreviewData.value().generalMessageData,
        batteryMessageData = homeScreenPreviewData.value().batteryMessageData,
        connectionMessageData = homeScreenPreviewData.value().connectionMessageData,
    )
}
