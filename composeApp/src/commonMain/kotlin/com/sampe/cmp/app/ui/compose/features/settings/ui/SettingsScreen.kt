package com.sampe.cmp.app.ui.compose.features.settings.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.enums.ThemePreference
import org.jetbrains.compose.resources.stringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.theme_title

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    isSinglePan: Boolean,
    themePref: Int,
    onPreferenceChanged:(ThemePreference) -> Unit
) {
    SettingsScaffold(
        modifier = modifier,
        isSinglePan = isSinglePan,
        themePref = themePref,
        onPreferenceChanged = onPreferenceChanged
    )
}

@Composable
fun SettingsScaffold(
    modifier: Modifier = Modifier,
    isSinglePan: Boolean,
    themePref: Int,
    onPreferenceChanged:(ThemePreference) -> Unit
) {
    val themePreference = ThemePreference.entries[themePref]

    if (isSinglePan) {
        SinglePanDeviceScaffold(
            modifier = modifier,
            themePreference = themePreference,
            onPreferenceChanged = onPreferenceChanged
        )
    } else {
        SinglePanDeviceScaffold(
            modifier = modifier,
            themePreference = themePreference,
            onPreferenceChanged = onPreferenceChanged
        )
    }
}

@Composable
fun SinglePanDeviceScaffold(
    modifier: Modifier = Modifier,
    themePreference: ThemePreference,
    onPreferenceChanged:(ThemePreference) -> Unit
) {

    val showThemeDialog = remember { mutableStateOf(false) }
    Scaffold(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(it)
                .padding(16.dp)
                .clickable {
                    showThemeDialog.value = true
                },
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(Res.string.theme_title),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = themePreference.name,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    if (showThemeDialog.value) {
        AppThemeDialog(
            selectedTheme = themePreference,
            onThemeChanged = onPreferenceChanged,
            onDismissRequest = {
                showThemeDialog.value = false
            }
        )
    }
}

@Composable
internal fun AppThemeDialog(
    selectedTheme: ThemePreference,
    onThemeChanged: (ThemePreference) -> Unit,
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = stringResource(Res.string.theme_title)) },
        text = {
            Column {
                ThemePreference.entries.forEach { item ->
                    val isSelected = selectedTheme.value == item.value

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(8.dp)
                            .selectable(
                                selected = isSelected,
                                onClick = {
                                    onThemeChanged(item)
                                    onDismissRequest()
                                },
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = {
                                onThemeChanged(item)
                                onDismissRequest()
                            },
                        )
                        Text(
                            text = stringResource(item.titleRes),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 16.dp),
                        )
                    }
                }
            }
        },
        confirmButton = {},
        dismissButton = {},
    )
}