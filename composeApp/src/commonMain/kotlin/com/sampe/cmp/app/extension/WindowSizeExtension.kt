package com.sampe.cmp.app.extension

import androidx.window.core.layout.WindowSizeClass


fun WindowSizeClass.isSinglePane() =
    !isWidthAtLeastBreakpoint(
        widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND
    )