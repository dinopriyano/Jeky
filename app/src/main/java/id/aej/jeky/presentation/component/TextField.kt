package id.aej.jeky.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.aej.jeky.R
import id.aej.jeky.presentation.theme.Black
import id.aej.jeky.presentation.theme.Border
import id.aej.jeky.presentation.theme.Icon
import id.aej.jeky.presentation.theme.Label
import id.aej.jeky.presentation.theme.Primary

/**
 * Created by dino.priyano on 07/05/23.
 */

@Composable fun PlainTextField(
  modifier: Modifier = Modifier,
  value: String = "",
  label: String = "",
  placeholder: String = "",
  keyboardOptions: KeyboardOptions = KeyboardOptions(),
  onValueChange: (String) -> Unit
) {
  BaseTextField(
    modifier = modifier,
    value = value,
    label = label,
    placeholder = placeholder,
    keyboardOptions = keyboardOptions,
    onValueChange = onValueChange
  )
}

@Composable fun TrailingTextField(
  modifier: Modifier = Modifier,
  value: String = "",
  label: String = "",
  placeholder: String = "",
  trailingIcon: (@Composable () -> Unit)? = null,
  keyboardOptions: KeyboardOptions = KeyboardOptions(),
  onValueChange: (String) -> Unit
) {
  BaseTextField(
    modifier = modifier,
    value = value,
    label = label,
    placeholder = placeholder,
    trailingIcon = trailingIcon,
    keyboardOptions = keyboardOptions,
    onValueChange = onValueChange
  )
}

@Composable fun PasswordTextField(
  modifier: Modifier = Modifier,
  value: String = "",
  label: String = "",
  placeholder: String = "",
  onValueChange: (String) -> Unit
) {

  var shouldShowPassword by remember {
    mutableStateOf(false)
  }

  BaseTextField(
    modifier = modifier,
    value = value,
    label = label,
    placeholder = placeholder,
    trailingIcon = {
      Icon(
        modifier = Modifier.clickable {
          shouldShowPassword = !shouldShowPassword
        },
        imageVector = if (shouldShowPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
        contentDescription = ""
      )
    },
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    visualTransformation = if (shouldShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
    onValueChange = onValueChange
  )

}

@OptIn(ExperimentalMaterial3Api::class) @Composable fun BaseTextField(
  modifier: Modifier = Modifier,
  value: String = "",
  trailingIcon: (@Composable () -> Unit)? = null,
  label: String = "",
  placeholder: String = "",
  keyboardOptions: KeyboardOptions = KeyboardOptions(),
  visualTransformation: VisualTransformation = VisualTransformation.None,
  onValueChange: (String) -> Unit
) {
  Column(
    modifier = modifier
  ) {
    Text(
      text = label,
      style = MaterialTheme.typography.labelMedium,
      color = Black,
      modifier = Modifier.fillMaxWidth()
    )
    OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      colors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Black,
        unfocusedBorderColor = Border,
        focusedBorderColor = Primary,
        placeholderColor = Label,
        unfocusedTrailingIconColor = Icon,
        focusedTrailingIconColor = Primary
      ),
      shape = RoundedCornerShape(15.dp),
      placeholder = {
        Text(
          text = placeholder,
          style = MaterialTheme.typography.bodyMedium
        )
      },
      trailingIcon = {
        trailingIcon?.invoke()
      },
      visualTransformation = visualTransformation,
      keyboardOptions = keyboardOptions,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 6.dp)
    )
  }
}

@Preview(showBackground = true) @Composable fun PlainTextFieldPreview() {
  PlainTextField(
    value = "",
    label = "Nama Lengkap",
    placeholder = "Nama lengkap anda",
    onValueChange = {}
  )
}

@Preview(showBackground = true) @Composable fun TrailingTextFieldPreview() {
  TrailingTextField(
    value = "",
    label = "Email",
    placeholder = "Masukan email",
    trailingIcon = {
                   Icon(painter = painterResource(id = R.drawable.ic_mail), contentDescription = "")
    },
    onValueChange = {}
  )
}

@Preview(showBackground = true) @Composable fun PasswordTextFieldPreview() {
  PasswordTextField(
    value = "",
    label = "Password",
    placeholder = "Masukan password",
    onValueChange = {}
  )
}