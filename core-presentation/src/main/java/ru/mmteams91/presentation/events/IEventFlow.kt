package ru.mmteams91.presentation.events

import kotlinx.coroutines.flow.Flow

interface IEventFlow {
    fun events(): Flow<Event>
}