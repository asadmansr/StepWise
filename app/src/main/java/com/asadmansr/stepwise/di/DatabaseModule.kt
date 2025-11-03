package com.asadmansr.stepwise.di

import android.app.Application
import androidx.room.Room
import com.asadmansr.stepwise.data.database.StepWiseDatabase
import com.asadmansr.stepwise.data.database.StepWiseDatabase.Companion.DATABASE_NAME
import com.asadmansr.stepwise.data.database.dao.StepDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): StepWiseDatabase {
        return Room
            .databaseBuilder(
                application,
                StepWiseDatabase::class.java,
                DATABASE_NAME
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideStepsDao(appDatabase: StepWiseDatabase): StepDao {
        return appDatabase.stepDao()
    }
}