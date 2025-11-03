package com.asadmansr.stepwise.di

import com.asadmansr.stepwise.data.repository.ManageStepRepository
import com.asadmansr.stepwise.data.repository.StepRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsStepRepository(manageStepRepository: ManageStepRepository): StepRepository
}
