package com.example.igdb.external.extensions

private val classMap = mutableMapOf<String, Class<*>>()

private inline fun <reified T : Any> Any.castOrNull() = this as? T

fun <T> String.loadClassOrNull(): Class<out T>? =
    classMap.getOrPut(this) {
        try {
            Class.forName(this)
        } catch (e: ClassNotFoundException) {
            return null
        }
    }.castOrNull()