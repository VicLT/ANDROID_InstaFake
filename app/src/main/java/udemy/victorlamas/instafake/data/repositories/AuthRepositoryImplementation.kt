package udemy.victorlamas.instafake.data.repositories

import udemy.victorlamas.instafake.data.response.UserResponse
import udemy.victorlamas.instafake.data.response.toDomain
import udemy.victorlamas.instafake.domain.entitites.UserEntity
import udemy.victorlamas.instafake.domain.repositories.AuthRepository

class AuthRepositoryImplementation(/*api: ApiService, dataSource: DataSource*/): AuthRepository {

    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse: UserResponse = UserResponse(
            "",
            "",
            "",
            0,
            listOf(""),
            0
        )
        return userResponse.toDomain()
    }

}