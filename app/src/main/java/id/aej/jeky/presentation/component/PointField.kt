package id.aej.jeky.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import id.aej.jeky.R
import id.aej.jeky.presentation.theme.Primary

/**
 * Created by dino.priyano on 28/05/23.
 */

@OptIn(ExperimentalMaterial3Api::class) @Composable fun PointField(
  modifier: Modifier = Modifier,
  readOnly: Boolean = false,
  backgroundColor: Color = Color.White,
  borderColor: Color = Color.Transparent,
  elevation: Dp = 15.dp,
  editButtonVisible: Boolean = true,
  pickupValue: String,
  destinationValue: String,
  pickupPlaceholder: String = "",
  destinationPlaceholder: String = "",
  pickupFocusRequester: FocusRequester? = null,
  destinationFocusRequester: FocusRequester? = null,
  onPickupValueChange: ((String) -> Unit)? = null,
  onDestinationValueChange: ((String) -> Unit)? = null,
  onPickupFocused: (() -> Unit)? = null,
  onDestinationFocused: (() -> Unit)? = null,
  onEditButtonClick: (() -> Unit)? = null
) {
  ConstraintLayout(
    modifier = modifier
      .border(
        if (borderColor == Color.Transparent) 0.dp else 1.dp,
        borderColor,
        RoundedCornerShape(25.dp)
      )
      .shadow(elevation, RoundedCornerShape(25.dp))
      .clip(RoundedCornerShape(25.dp))
      .background(backgroundColor)
  ) {
    val (fieldPickupRef, fieldDestinationRef, dividerRef, editButtonRef) = createRefs()

    if(editButtonVisible) {
      OutlinedButton(
        onClick = { onEditButtonClick?.invoke() },
        shape = CircleShape,
        border = BorderStroke(1.dp, Primary),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        modifier = Modifier
          .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
          .constrainAs(editButtonRef) {
            top.linkTo(parent.top)
            end.linkTo(parent.end, 16.dp)
            bottom.linkTo(parent.bottom)
          }
      ) {
        Text(
          text = stringResource(R.string.edit),
          color = Primary,
          style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight.SemiBold
          )
        )
      }
    }

    TextFieldIcon(value = pickupValue,
      placeholder = pickupPlaceholder,
      icon = R.drawable.ic_pickup,
      onValueChanged = { onPickupValueChange?.invoke(it) },
      readOnly = readOnly,
      modifier = Modifier
        .then(
          pickupFocusRequester?.let {
            Modifier.focusRequester(it)
          } ?: run {
            Modifier
          }
        )
        .onFocusChanged { if(it.isFocused) onPickupFocused?.invoke() }
        .constrainAs(fieldPickupRef) {
          top.linkTo(parent.top, 16.dp)
          start.linkTo(parent.start, 16.dp)
          if (editButtonVisible) {
            end.linkTo(editButtonRef.start, 8.dp)
          } else {
            end.linkTo(parent.end, 16.dp)
          }
          width = Dimension.fillToConstraints
        }
    )

    Divider(modifier = Modifier
      .constrainAs(dividerRef) {
        top.linkTo(fieldPickupRef.bottom, 6.dp)
        start.linkTo(fieldPickupRef.start, 40.dp)
        end.linkTo(fieldPickupRef.end)
        width = Dimension.fillToConstraints
      }
    )

    TextFieldIcon(value = destinationValue,
      placeholder = destinationPlaceholder,
      icon = R.drawable.ic_destination,
      onValueChanged = { onDestinationValueChange?.invoke(it) },
      readOnly = readOnly,
      modifier = Modifier
        .then(
          destinationFocusRequester?.let {
            Modifier.focusRequester(it)
          } ?: run {
            Modifier
          }
        )
        .onFocusChanged { if(it.isFocused) onDestinationFocused?.invoke() }
        .constrainAs(fieldDestinationRef) {
          top.linkTo(dividerRef.bottom, 6.dp)
          start.linkTo(fieldPickupRef.start)
          bottom.linkTo(parent.bottom, 16.dp)
          end.linkTo(fieldPickupRef.end)
          width = Dimension.fillToConstraints
        }
    )
  }
}

@ExperimentalMaterial3Api @Composable fun TextFieldIcon(
  modifier: Modifier = Modifier,
  value: String,
  placeholder: String,
  @DrawableRes icon: Int,
  readOnly: Boolean = false,
  onValueChanged: (String) -> Unit
) {
  BasicTextField(
    value = value,
    onValueChange = onValueChanged,
    singleLine = true,
    readOnly = readOnly,
    textStyle = MaterialTheme.typography.bodyMedium.copy(
      fontWeight = FontWeight.Medium
    ),
    decorationBox = { innerTextField ->
      Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(
          painter = painterResource(id = icon),
          contentDescription = "Leading Icon",
          tint = Color.Unspecified,
          modifier = Modifier.padding(end = 16.dp)
        )
        Box(modifier = Modifier.fillMaxWidth()) {
          if (value.isEmpty()) {
            Text(
              text = placeholder, style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
              )
            )
          }
          innerTextField()
        }
      }
    },
    modifier = modifier
  )
}