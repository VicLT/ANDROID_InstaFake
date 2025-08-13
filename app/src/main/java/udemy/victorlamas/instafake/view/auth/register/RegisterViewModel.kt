package udemy.victorlamas.instafake.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onNumberChanged(newNumber: String) {
        _uiState.update { state ->
            state.copy(
                number = newNumber
            )
        }
        verifyRegister()
    }

    private fun verifyRegister() {
        val enabledRegister = isNumberValid(uiState.value.number)
        _uiState.update {
            it.copy(isRegisterEnabled = enabledRegister)
        }
    }

    private fun isNumberValid(number: String): Boolean =
        Patterns.PHONE.matcher(number).matches()
}

data class RegisterUiState(
    val number: String = "",
    val isRegisterEnabled: Boolean = false
)