package br.com.alura.apiforum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
