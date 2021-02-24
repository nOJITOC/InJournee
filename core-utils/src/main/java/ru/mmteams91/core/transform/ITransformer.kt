package ru.mmteams91.core.transform

interface ITransformer<From, To> {

    fun transform(from: From): To

    fun transform(from: Collection<From>): List<To> = from.map { transform(it) }

    fun map(from: From): To = transform(from)

    fun map(from: Collection<From>): List<To> = transform(from)
}