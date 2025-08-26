package udemy.victorlamas.instafake.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onChangeMode() {
        _uiState.update {
            it.copy(isPhoneMode = !it.isPhoneMode, value = "")
        }
    }

    fun onRegisterChanged(value: String) {
        _uiState.update { state ->
            val isEnabled = if (state.isPhoneMode) {
                value.length >= 9 && value.all { it.isDigit() }
            } else {
                Patterns.EMAIL_ADDRESS.matcher(value).matches()
            }
            state.copy(isRegisterEnabled = isEnabled, value = value)
        }
    }
}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isRegisterEnabled: Boolean = false
)