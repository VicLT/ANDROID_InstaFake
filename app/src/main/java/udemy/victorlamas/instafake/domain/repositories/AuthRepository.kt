package udemy.victorlamas.instafake.domain.repositories

interface AuthRepository {
    fun doLogin(user: String, password: String): Boolean
}