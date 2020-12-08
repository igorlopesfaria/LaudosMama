package br.com.laudosmama.repository.data

sealed class Error {

    object UnknownError : Error()

    object ItemNotFoundError : Error()

    object NetworkError : Error()

    data class ServerError<T>(val data: T) : Error()

    data class  DatabaseError<T>(val data: T) : Error()
}
