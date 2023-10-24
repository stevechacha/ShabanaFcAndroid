package com.fcshabana.shabanafcandroid.greetingphrasegenerator

import android.os.Build
import androidx.annotation.RequiresApi
import com.fcshabana.shabanafcandroid.greetingphrasegenerator.GreetingPhraseGenerator
import com.fcshabana.shabanafcandroid.greetingphrasegenerator.isMorning
import com.fcshabana.shabanafcandroid.greetingphrasegenerator.isNoon
import java.time.LocalTime

/**
 * A concrete implementation of [GreetingPhraseGenerator] that generates
 * greeting phrases based on the provided [time] value. By default the
 * [time] property is set to [LocalTime.now].
 * @see CurrentTimeBasedGreetingPhraseGenerator
 */
@RequiresApi(Build.VERSION_CODES.O)
class TimeBasedGreetingPhraseGenerator  constructor(
    private val time: LocalTime = LocalTime.now()
) : GreetingPhraseGenerator {

    override fun generatePhrase(): String = when {
        time.isMorning -> "Good morning"
        time.isNoon -> "Good afternoon"
        else -> "Good evening"
    }
}
