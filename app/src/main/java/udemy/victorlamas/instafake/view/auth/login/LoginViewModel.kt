package udemy.victorlamas.instafake.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import udemy.victorlamas.instafake.domain.usecases.LoginUseCase

class LoginViewModel(val login: LoginUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        _uiState.update { state ->
            state.copy(
                email = newEmail
            )
        }
        verifyLogin()
    }


    fun onPasswordChanged(newPass: String) {
        _uiState.update { state ->
            state.copy(
                password = newPass
            )
        }
        verifyLogin()
    }

    fun onClickSelected() {
        viewModelScope.launch(Dispatchers.IO) {
            login(_uiState.value.email, _uiState.value.password)
        }
    }

    private fun verifyLogin() {
        val enabledLogin =
            isEmailValid(uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    private fun isEmailValid(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String): Boolean =
        password.length >= 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)