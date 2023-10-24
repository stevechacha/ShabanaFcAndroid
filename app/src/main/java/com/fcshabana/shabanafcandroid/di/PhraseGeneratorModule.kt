package com.fcshabana.shabanafcandroid.di

import com.fcshabana.shabanafcandroid.greetingphrasegenerator.CurrentTimeBasedGreetingPhraseGenerator
import com.fcshabana.shabanafcandroid.greetingphrasegenerator.GreetingPhraseGenerator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PhraseGeneratorModule {
    @Binds
    abstract fun bindCurrentTimeBasedGreetingPhraseGenerator(
        impl: CurrentTimeBasedGreetingPhraseGenerator
    ): GreetingPhraseGenerator
}