package id.aej.jeky.presentation.screen.pick_location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.aej.jeky.R
import id.aej.jeky.presentation.component.PointField
import id.aej.jeky.presentation.theme.Border
import id.aej.jeky.presentation.theme.LightGray

/**
 * Created by dino.priyano on 04/06/23.
 */

@Composable fun PickLocationBottomSheet(isToGetPickupLocation: Boolean) {

  var pickup by remember {
    mutableStateOf("")
  }
  var destination by remember {
    mutableStateOf("")
  }

  val title = if (isToGetPickupLocation) {
    stringResource(id = R.string.pickup_title)
  } else {
    stringResource(id = R.string.destination_title)
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(top = 16.dp)
    ) {
      IconButton(modifier = Modifier.size(24.dp), onClick = { /*TODO*/ }) {
        Icon(
          painter = painterResource(id = R.drawable.ic_close),
          contentDescription = "Close Pick Location"
        )
      }
      Text(
        modifier = Modifier.padding(start = 16.dp),
        text = title,
        style = MaterialTheme.typography.labelLarge.copy(
          fontSize = 18.sp
        )
      )
    }

    PointField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 18.dp)
        .padding(horizontal = 24.dp),
      pickupValue = pickup,
      destinationValue = destination,
      pickupPlaceholder = stringResource(id = R.string.pickup_location_txt),
      destinationPlaceholder = stringResource(R.string.destination_location_txt),
      onPickupFocused = {},
      onDestinationFocused = {},
      elevation = 0.dp,
      backgroundColor = LightGray,
      borderColor = Border,
      editButtonVisible = false,
      onPickupValueChange = {
        pickup = it
      },
      onDestinationValueChange = {
        destination = it
      },
      onEditButtonClick = {
        // TODO: open pick location bottom sheet
      }
    )

    Divider(
      modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
      thickness = 1.dp,
      color = Border
    )
  }
}