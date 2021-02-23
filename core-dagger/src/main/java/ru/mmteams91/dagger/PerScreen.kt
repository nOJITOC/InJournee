package ru.mmteams91.dagger

import javax.inject.Scope

/**
 * Identifies a type that the injector instantiates once per screen.
 *
 * @see [javax.inject.Scope]
 * */
@Scope
@Retention
@MustBeDocumented
annotation class PerScreen