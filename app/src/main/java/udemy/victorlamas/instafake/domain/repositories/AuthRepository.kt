package udemy.victorlamas.instafake.domain.repositories

import udemy.victorlamas.instafake.domain.entitites.UserEntity

interface AuthRepository {
    fun doLogin(user: String, password: String): UserEntity
}