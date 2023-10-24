package com.fcshabana.shabanafcandroid.greetingphrasegenerator

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import javax.inject.Inject

/**
 * A [GreetingPhraseGenerator] that uses [TimeBasedGreetingPhraseGenerator]
 * under the hood by passing [LocalTime.now] to its constructor. This class
 * was mainly created because default constructor parameters causes an exception
 * when injecting. A constructor with default arguments will generate two constructors
 * in java that are annotated with [Inject]. This will cause ambiguity for the hilt
 * annotation processor. In order to circumvent this, inject this class instead of
 * directly using [TimeBasedGreetingPhraseGenerator]. If the logic of that class
 * is to be tested, use that class by passing the time to be tested directly in its
 * constructor.
 */
class CurrentTimeBasedGreetingPhraseGenerator @Inject constructor() : GreetingPhraseGenerator {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun generatePhrase(): String =
        TimeBasedGreetingPhraseGenerator(LocalTime.now()).generatePhrase()

}