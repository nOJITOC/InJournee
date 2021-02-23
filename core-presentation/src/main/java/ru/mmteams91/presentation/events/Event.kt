package ru.mmteams91.presentation.events

data class Event(
    val key: String,
    val payload: Any? = null
) {
    inline fun <reified T> getTypedPayload() = payload as? T
}