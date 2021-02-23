package ru.mmteams91.presentation.events

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventPublisher @Inject constructor() : IEventEmitter, IEventFlow {
    private val eventsFlow = MutableSharedFlow<Event>()
    var coroutineScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())

    override fun emitEvent(event: Event) {
        coroutineScope.launch {
            eventsFlow.emit(event)
        }
    }

    override fun events(): Flow<Event> = eventsFlow
}