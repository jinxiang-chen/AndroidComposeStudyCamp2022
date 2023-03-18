package fu.trainnin.gridcompose.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val title: Int,
    val likeCount: Int,
    @DrawableRes val drawable: Int
)