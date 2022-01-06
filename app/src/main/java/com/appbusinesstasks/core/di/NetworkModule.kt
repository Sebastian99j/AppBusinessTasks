package com.appbusinesstasks.core.di

import com.appbusinesstasks.core.data.service.NetworkService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        return Retrofit.Builder()
            .baseUrl("http://192.168.192.3:8083/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken():String {
        return "12t29a01p11qer24f1p901azm4^14dl01axc1"
    }
}