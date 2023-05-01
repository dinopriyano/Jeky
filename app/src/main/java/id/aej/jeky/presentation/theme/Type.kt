package id.aej.jeky.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import id.aej.jeky.R

val MaisonNeueFam = FontFamily(
  Font(R.font.maison_neue_book, FontWeight.Normal),
  Font(R.font.maison_neue_medium, FontWeight.Medium),
  Font(R.font.maison_neue_demi, FontWeight.SemiBold),
  Font(R.font.maison_neue_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  bodySmall = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
  ),
  titleLarge = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp
  ),
  labelLarge = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp
  ),
  labelMedium = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp
  ),
  labelSmall = TextStyle(
    fontFamily = MaisonNeueFam,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  )

  /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)