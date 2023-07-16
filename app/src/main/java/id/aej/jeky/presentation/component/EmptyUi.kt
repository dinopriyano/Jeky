package id.aej.jeky.presentation.component

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

/**
 * Created by dino.priyano on 16/07/23.
 */

@Composable fun EmptyUi(
  modifier: Modifier,
  @RawRes animationResource: Int,
  title: String,
  description: String,
  buttonText: String,
  onButtonClick: () -> Unit
) {

  Column(
    modifier = modifier
  ) {
    val lottieComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationResource))
    LottieAnimation(
      composition = lottieComposition,
      iterations = LottieConstants.IterateForever,
      contentScale = ContentScale.FillHeight,
      modifier = Modifier
        .fillMaxWidth()
        .sizeIn(maxHeight = 250.dp)
        .padding(top = 60.dp)
        .padding(horizontal = 24.dp)
    )
    TextHeader(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(top = 36.dp),
      headerText = title,
      supportText = description
    )
    JekyButton(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(top = 36.dp, bottom = 24.dp),
      buttonText = buttonText
    ) {
      onButtonClick.invoke()
    }
  }

}