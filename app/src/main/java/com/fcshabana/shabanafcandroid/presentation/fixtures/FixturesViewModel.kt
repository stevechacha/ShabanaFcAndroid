package com.fcshabana.shabanafcandroid.presentation.fixtures

import androidx.lifecycle.ViewModel
import com.fcshabana.shabanafcandroid.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FixturesViewModel : ViewModel() {
    private val _fixtureState = MutableStateFlow(FixturesState())
    val fixturesState: StateFlow<FixturesState> = _fixtureState

    fun onTriggerEvent(event: FixturesEvent) {
        when (event) {
            is FixturesEvent.OnClick -> {

            }
            is FixturesEvent.OnClickWithParam -> {

            }
            is FixturesEvent.OnEventPageChange -> {
                _fixtureState.update { it.copy(settledPage = event.settledPage) }
            }
        }
    }
}

data class FixturesState(
    val settledPage: Int = 0
)

sealed class FixturesEvent {
    object OnClick : FixturesEvent()
    data class OnClickWithParam(val param: String) : FixturesEvent()
    data class OnEventPageChange(val settledPage: Int) : FixturesEvent()
}

enum class FixturesPages(val title: Int) {
    FIXTURE(title = R.string.fixtures),
    RESULTS(title = R.string.results),
    TABLE(title = R.string.table),
    PLAYERS(title = R.string.players),
    STAFF(title = R.string.staff)

}