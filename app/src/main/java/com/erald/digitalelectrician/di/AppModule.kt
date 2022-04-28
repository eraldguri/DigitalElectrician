package com.erald.digitalelectrician.di

import com.erald.digitalelectrician.repository.HomeRepository
import com.erald.digitalelectrician.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHomeRepository() : HomeRepository = HomeRepositoryImpl()
}