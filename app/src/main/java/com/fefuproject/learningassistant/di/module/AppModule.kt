package com.fefuproject.learningassistant.di.module

import android.content.Context
import com.fefuproject.learningassistant.App
import com.fefuproject.learningassistant.data.locale.AppDatabase
import com.fefuproject.learningassistant.data.locale.UserDao
import com.fefuproject.learningassistant.data.remote.UserRemoteDataSource
import com.fefuproject.learningassistant.data.remote.UserService
import com.fefuproject.learningassistant.data.repository.UserRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideUsersService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideUsersRemoteDataSource(usersService: UserService) = UserRemoteDataSource(usersService)


    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideUsersDao(db: AppDatabase) = db.userDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: UserRemoteDataSource,
        localDataSource: UserDao
    ) = UserRepository(remoteDataSource, localDataSource)

}