package udemy.victorlamas.instafake.view.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import udemy.victorlamas.instafake.R
import udemy.victorlamas.instafake.view.core.components.InstaButtonPrimary
import udemy.victorlamas.instafake.view.core.components.InstaButtonSecondary
import udemy.victorlamas.instafake.view.core.components.InstaText
import udemy.victorlamas.instafake.view.core.components.InstaTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()) {

    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                text = stringResource(R.string.register_screen_title),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
            InstaText(
                text = stringResource(R.string.register_screen_subtitle),
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(Modifier.height(16.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.number,
                shape = RoundedCornerShape(30),
                label = stringResource(R.string.register_screen_textfield_number),
                onValueChange = { registerViewModel.onNumberChanged(it) }
            )
            Spacer(Modifier.height(16.dp))
            InstaText(
                text = stringResource(R.string.register_screen_text_warning)
            )
            Spacer(Modifier.height(12.dp))
            InstaButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = uiState.isRegisterEnabled,
                text = stringResource(R.string.register_screen_button_next)
            )
            Spacer(Modifier.height(4.dp))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                text = stringResource(R.string.register_screen_button_register),
                textColor = MaterialTheme.colorScheme.onPrimary,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.weight(1f))
            InstaText(
                modifier = Modifier.padding(4.dp),
                text = stringResource(R.string.register_screen_text_find_my_account),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}