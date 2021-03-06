package ru.mmteams91.dagger

import javax.inject.Scope

/**
 * Identifies a type that the injector instantiates once per feature.
 *
 * @see [javax.inject.Scope]
 * */
@Scope
@Retention
@MustBeDocumented
annotation class PerFeature