package com.smartherd.capstonelittlelemonapp.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.smartherd.capstonelittlelemonapp.R

// Set of Material typography styles to start with

@RequiresApi(Build.VERSION_CODES.Q)
val karla = FontFamily(Font(R.font.karla_regular))
val markazi = FontFamily(Font(R.font.markazi_text_regular))

@RequiresApi(Build.VERSION_CODES.Q)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        color = AppGray
    ),
    bodySmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
        color = AppYellow
    ),
    displaySmall =  TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        background = AppYellow,
        textAlign = TextAlign.Center,
        color = AppBlack

    ),
    titleMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 26.sp,
        color = AppBlack

    ),
    headlineMedium =  TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        textAlign = TextAlign.Center,
        color = AppGray

),
    bodyMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = AppBlack
),
    displayMedium =  TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        color = AppBlack
),
    titleSmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        color = AppBlack

    ),
    )