package udemy.victorlamas.instafake.data.response

import udemy.victorlamas.instafake.domain.entitites.UserEntity
import udemy.victorlamas.instafake.domain.entitites.UserMode.COMPANY_USER
import udemy.victorlamas.instafake.domain.entitites.UserMode.CONTENT_CREATOR_USER
import udemy.victorlamas.instafake.domain.entitites.UserMode.REGULAR_USER

data class UserResponse(
    val userId: String,
    val name: String,
    val nickname: String,
    val followers: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {

    val userMode = when(userType) {
        REGULAR_USER.userType -> REGULAR_USER
        CONTENT_CREATOR_USER.userType -> CONTENT_CREATOR_USER
        COMPANY_USER.userType -> COMPANY_USER
        else -> REGULAR_USER
    }

    return UserEntity(
        userId = userId,
        name = name,
        nickname = nickname,
        followers = followers,
        following = following,
        userMode = userMode
    )
}