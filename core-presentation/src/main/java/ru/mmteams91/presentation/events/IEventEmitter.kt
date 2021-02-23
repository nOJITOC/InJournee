package ru.mmteams91.presentation.events

interface IEventEmitter {
    fun emitEvent(event: Event)

    fun emitEvent(key: String, payload: Any? = null) = emitEvent(Event(key, payload))
}