package id.aej.jeky.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import id.aej.jeky.presentation.theme.Primary

/**
 * Created by dino.priyano on 16/07/23.
 */

@Composable fun JekyButton(
  modifier: Modifier,
  buttonText: String,
  enabled: Boolean = true,
  shape: Shape = RoundedCornerShape(15.dp),
  color: ButtonColors = ButtonDefaults.buttonColors(
    contentColor = Color.White,
    containerColor = Primary
  ),
  contentPadding: PaddingValues = PaddingValues(vertical = 16.dp),
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    enabled = enabled,
    colors = color,
    onClick = {
      onClick.invoke()
    },
    contentPadding = contentPadding
  ) {
    Text(
      text = buttonText,
      style = MaterialTheme.typography.labelMedium
    )
  }
}