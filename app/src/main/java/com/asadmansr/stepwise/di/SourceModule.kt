package com.asadmansr.stepwise.di

import com.asadmansr.stepwise.data.source.StepDaoSource
import com.asadmansr.stepwise.data.source.StepSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SourceModule {

    @Binds
    fun bindsStepSource(stepDaoSource: StepDaoSource): StepSource
}