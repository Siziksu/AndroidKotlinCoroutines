package com.siziksu.ui.view.common

/**
 * This mapper will be used to map an object into another.
 *
 * @param <U> unmapped object
 * @param <M> mapped object
 */
abstract class Mapper<U, M> {

    fun map(unmappedList: List<U>): List<M> = unmappedList.map { map(it) }

    abstract fun map(unmapped: U): M
}
