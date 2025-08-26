package udemy.victorlamas.instafake.view.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun InstaTextField(
    value: String,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    label: String = "",
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        value = value,
        label = {
            InstaText(text = label)
        },
        onValueChange = { onValueChange(it) }
    )
}