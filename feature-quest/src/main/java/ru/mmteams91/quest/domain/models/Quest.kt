package ru.mmteams91.quest.domain.models

data class Quest(
    val id: Long,
    val points: List<Place>
)
