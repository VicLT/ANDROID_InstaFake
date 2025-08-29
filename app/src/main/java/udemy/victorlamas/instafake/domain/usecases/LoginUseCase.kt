package udemy.victorlamas.instafake.domain.usecases

import udemy.victorlamas.instafake.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(val authRepository: AuthRepository) {
    operator fun invoke(user: String, password: String) {
        if (user.contains("@hotmail.com")) {
            return
        }
        val response = authRepository.doLogin(user, password)
    }
}