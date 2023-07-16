package id.aej.jeky.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by dino.priyano on 16/07/23.
 */

@Parcelize
data class EmptyStateModel(
  val animationRes: Int,
  val title: String,
  val description: String,
  val buttonText: String
): Parcelable
