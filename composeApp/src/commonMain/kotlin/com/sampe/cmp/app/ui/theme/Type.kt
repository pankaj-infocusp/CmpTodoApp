package com.sampe.cmp.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.sans_bold
import sampecmpapp.composeapp.generated.resources.sans_regular
import sampecmpapp.composeapp.generated.resources.sans_semi_bold

val bodyFontFamily @Composable get() = FontFamily(
    Font(
        resource = Res.font.sans_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.sans_semi_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = Res.font.sans_bold,
        weight = FontWeight.Bold
    ),
)

val displayFontFamily @Composable get() = FontFamily(
    Font(
        resource = Res.font.sans_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.sans_semi_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = Res.font.sans_bold,
        weight = FontWeight.Bold
    ),
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography @Composable get() = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)

