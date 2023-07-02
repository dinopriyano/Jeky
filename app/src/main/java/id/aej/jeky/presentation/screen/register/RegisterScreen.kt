package id.aej.jeky.presentation.screen.register

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import id.aej.jeky.R
import id.aej.jeky.core.domain.model.User
import id.aej.jeky.presentation.component.PasswordTextField
import id.aej.jeky.presentation.component.PlainTextField
import id.aej.jeky.presentation.component.TextHeader
import id.aej.jeky.presentation.component.TrailingTextField
import id.aej.jeky.presentation.theme.Black
import id.aej.jeky.presentation.theme.Primary

/**
 * Created by dino.priyano on 07/05/23.
 */

@Composable fun RegisterScreen(
  viewModel: RegisterViewModel,
  onNavigateBack: () -> Unit,
  onNavigateToHome: () -> Unit
) {
  var name by remember {
    mutableStateOf("")
  }
  var phone by remember {
    mutableStateOf("")
  }
  var email by remember {
    mutableStateOf("")
  }
  var password by remember {
    mutableStateOf("")
  }
  var confirmPassword by remember {
    mutableStateOf("")
  }
  val uiState by viewModel.registerUiState.collectAsState(initial = RegisterUiState.Idle)
  val context = LocalContext.current
  val haveAccount = stringResource(R.string.have_account) + stringResource(R.string.space)
  val loginText = stringResource(R.string.login)
  val registerString = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Black)) {
      pushStringAnnotation(tag = haveAccount, annotation = haveAccount)
      append(haveAccount)
    }
    withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
      pushStringAnnotation(tag = loginText, annotation = loginText)
      append(loginText)
    }
  }

  val isButtonEnable by remember {
    derivedStateOf {
      name.trim().isNotEmpty() &&
          phone.trim().isNotEmpty() &&
          email.trim().isNotEmpty() &&
          password.trim().isNotEmpty() &&
          confirmPassword == password
    }
  }

  LaunchedEffect(uiState) {
    when (uiState) {
      is RegisterUiState.Loading -> {

      }
      is RegisterUiState.Success -> {
        onNavigateBack.invoke()
      }
      is RegisterUiState.Error -> {
        Toast.makeText(context, "Error: ${(uiState as RegisterUiState.Error).message}", Toast.LENGTH_SHORT).show()
      }
      else -> Unit
    }
  }

  Column(modifier = Modifier
    .fillMaxSize()
    .verticalScroll(rememberScrollState())) {
    TextHeader(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 44.dp)
        .padding(horizontal = 24.dp),
      headerText = stringResource(R.string.register_title),
      supportText = stringResource(R.string.register_description)
    )
    PlainTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 36.dp)
        .padding(horizontal = 24.dp),
      value = name,
      label = stringResource(R.string.full_name),
      placeholder = stringResource(R.string.your_full_name),
      onValueChange = {
        name = it
      }
    )
    PlainTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp)
        .padding(horizontal = 24.dp),
      value = phone,
      label = stringResource(R.string.phone),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
      placeholder = stringResource(R.string.your_phone_number),
      onValueChange = {
        phone = it
      }
    )
    TrailingTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp)
        .padding(horizontal = 24.dp),
      value = email,
      label = stringResource(R.string.email),
      placeholder = stringResource(R.string.input_email),
      trailingIcon = {
        Icon(painter = painterResource(id = R.drawable.ic_mail), contentDescription = "Email Icon")
      },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
      onValueChange = {
        email = it
      }
    )
    PasswordTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp)
        .padding(horizontal = 24.dp),
      value = password,
      label = stringResource(R.string.password),
      placeholder = stringResource(R.string.input_password),
      onValueChange = {
        password = it
      }
    )
    PasswordTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp)
        .padding(horizontal = 24.dp),
      value = confirmPassword,
      label = stringResource(R.string.confirm_password),
      placeholder = stringResource(R.string.input_confirm_password),
      onValueChange = {
        confirmPassword = it
      }
    )
    Button(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(top = 60.dp),
      shape = RoundedCornerShape(15.dp),
      enabled = isButtonEnable,
      colors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = Primary
      ),
      onClick = {
        viewModel.register(
          User(
            email, password, name, phone
          )
        )
      },
      contentPadding = PaddingValues(vertical = 16.dp)
    ) {
      Text(
        text = stringResource(R.string.register),
        style = MaterialTheme.typography.labelMedium
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    ClickableText(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(bottom = 30.dp, top = 70.dp),
      text = registerString,
      style = MaterialTheme.typography.bodyMedium.copy(
        textAlign = TextAlign.Center
      ),
      onClick = { offset ->
        registerString.getStringAnnotations(offset, offset)
          .firstOrNull()?.let { span ->
            if(span.item == loginText) {
              onNavigateBack.invoke()
            }
          }
      }
    )
  }
}