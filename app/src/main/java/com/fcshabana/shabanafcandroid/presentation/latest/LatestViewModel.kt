package com.fcshabana.shabanafcandroid.presentation.latest

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.greetingphrasegenerator.GreetingPhraseGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LatestViewModel @Inject constructor(
    greetingPhraseGenerator: GreetingPhraseGenerator,
) : ViewModel() {

    val greetingPhrase = greetingPhraseGenerator.generatePhrase()

    private val _latestState = MutableStateFlow(LatestState())
    val latestState: StateFlow<LatestState> = _latestState

    fun onTriggerEvent(event: LatestEvent) {
        when (event) {
            is LatestEvent.OnClick -> {

            }

            is LatestEvent.OnClickWithParam -> {

            }

            is LatestEvent.OnEventPageChange -> {
                _latestState.update { it.copy(settledPage = event.settledPage) }
            }
        }
    }
}

data class LatestState(
    val settledPage: Int = 0
)

sealed class LatestEvent {
    object OnClick : LatestEvent()
    data class OnClickWithParam(val param: String) : LatestEvent()
    data class OnEventPageChange(val settledPage: Int) : LatestEvent()
}

enum class LatestPages(val title: Int) {
    FIXTURE(title = R.string.fixtures),
    RESULTS(title = R.string.results),
    TABLE(title = R.string.table),
    PLAYERS(title = R.string.players),
    STAFF(title = R.string.staff)

}