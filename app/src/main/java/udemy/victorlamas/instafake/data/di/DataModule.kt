package udemy.victorlamas.instafake.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import udemy.victorlamas.instafake.data.repositories.AuthRepositoryImplementation
import udemy.victorlamas.instafake.domain.repositories.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImplementation()
    }
}