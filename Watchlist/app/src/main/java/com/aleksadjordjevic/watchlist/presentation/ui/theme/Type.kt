package com.aleksadjordjevic.watchlist.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aleksadjordjevic.watchlist.R

val bebasNeueRegular = FontFamily(Font(R.font.bebas_neue_regular))
val questrialRegular = FontFamily(Font(R.font.questrial_regular))


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = bebasNeueRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 65.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = homeHeadlineColor
    ),
    labelSmall = TextStyle(
        fontFamily = questrialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = trackedMovieLabelColor
    ),
    labelMedium = TextStyle(
        fontFamily = questrialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = trackableMovieLabelColor
    ),
)