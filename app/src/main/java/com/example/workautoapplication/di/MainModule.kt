package com.example.workautoapplication.di

import android.app.Application
import android.content.Context
import com.example.workautoapplication.data.AutoListRepositoryImpl
import com.example.workautoapplication.presentation.AutoListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRepository(@ApplicationContext appContext: Context): AutoListRepositoryImpl {
        return AutoListRepositoryImpl(application = appContext as Application)
    }

    @Provides
    @Singleton
    fun provideAdapter(): AutoListAdapter = AutoListAdapter()


}