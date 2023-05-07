package id.aej.jeky.presentation.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import id.aej.jeky.R
import id.aej.jeky.presentation.component.PasswordTextField
import id.aej.jeky.presentation.component.TextHeader
import id.aej.jeky.presentation.component.TrailingTextField
import id.aej.jeky.presentation.navigation.Route

/**
 * Created by dino.priyano on 07/05/23.
 */

@Composable fun LoginScreen(
  navHostController: NavHostController
) {

  var email by remember {
    mutableStateOf("")
  }
  var password by remember {
    mutableStateOf("")
  }

  Column(modifier = Modifier.fillMaxSize()) {
    TextHeader(
      modifier = Modifier.fillMaxWidth().padding(top = 44.dp).padding(horizontal = 24.dp),
      headerText = "Selamat Datang",
      supportText = "Masukkan email dan password dari akun yang pernah kamu buat sebelumnya"
    )
    TrailingTextField(
      modifier = Modifier.fillMaxWidth().padding(top = 36.dp).padding(horizontal = 24.dp),
      value = email,
      label = "Email",
      placeholder = "Masukan email",
      trailingIcon = {
        Icon(painter = painterResource(id = R.drawable.ic_mail), contentDescription = "Email Icon")
      },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
      onValueChange = {
        email = it
      }
    )
    PasswordTextField(
      modifier = Modifier.fillMaxWidth().padding(top = 24.dp).padding(horizontal = 24.dp),
      value = password,
      label = "Password",
      placeholder = "Masukan password",
      onValueChange = {
        password = it
      }
    )
  }
}