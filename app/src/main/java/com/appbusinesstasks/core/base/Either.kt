package com.appbusinesstasks.core.base

sealed class Either<out L, out R> {
    data class Left<out L>(val dataL: L): Either<L, Nothing>()
    data class Right<out R>(val dataR: R): Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)
    fun <R> right(b: R) = Right(b)

    inline fun either(fnL: (L)-> Any, fnR: (R)-> Any): Any =
        when(this) {
            is Left -> fnL(dataL)
            is Right -> fnR(dataR)
        }
}

fun <A, B, C> ((A)-> B).c(f: (B) -> C): (A)-> C = {
    f(this(it))
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R)-> Either<L, T>): Either<L, T> =
    when(this) {
        is Either.Left -> Either.Left(dataL)
        is Either.Right -> fn(dataR)
    }

fun <T, L, R> Either<L, R>.map(fn: (R)-> (T)): Either<L, T> =
    this.flatMap(fn.c(::right))
