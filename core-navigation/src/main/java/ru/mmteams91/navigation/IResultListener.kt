package ru.mmteams91.navigation

interface IResultListener<T> {
    fun onResult(resultCode: Int, data: T?)
}