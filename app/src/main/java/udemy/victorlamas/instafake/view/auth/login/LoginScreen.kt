package udemy.victorlamas.instafake.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import udemy.victorlamas.instafake.R
import udemy.victorlamas.instafake.view.core.components.InstaButtonPrimary
import udemy.victorlamas.instafake.view.core.components.InstaButtonSecondary
import udemy.victorlamas.instafake.view.core.components.InstaText

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    navigateToRegister: () -> Unit
) {

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            InstaText(
                modifier = Modifier.padding(top = 22.dp),
                text = stringResource(R.string.login_screen_header_text_spain),
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instafake_logo),
                contentDescription = "InstaFake logo header"
            )
            Spacer(Modifier.weight(1f))

            // Body
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                label = {
                    InstaText(
                        text = stringResource(R.string.login_screen_textfield_email),
                    )
                },
                onValueChange = { loginViewModel.onEmailChanged(it) },
                shape = RoundedCornerShape(30)
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                label = {
                    InstaText(
                        text = stringResource(R.string.login_screen_textfield_password),
                    )
                },
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                shape = RoundedCornerShape(30)
            )
            Spacer(Modifier.height(12.dp))
            InstaButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = uiState.isLoginEnabled,
                text = stringResource(R.string.login_screen_button_login)
            )
            TextButton(onClick = {}) {
                InstaText(
                    text = stringResource(R.string.login_screen_text_forgot_password),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1.5f))

            // Footer
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRegister() },
                text = stringResource(R.string.login_screen_button_register)
            )
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Meta logo",
            )
        }
    }
}