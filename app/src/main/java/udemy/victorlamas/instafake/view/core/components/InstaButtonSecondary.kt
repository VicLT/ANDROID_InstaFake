package udemy.victorlamas.instafake.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import udemy.victorlamas.instafake.R

@Composable
fun InstaButtonSecondary(modifier: Modifier = Modifier) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {

        },
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        ),
    ) {
        InstaText(text = stringResource(R.string.register_screen_button_register))
    }
}