package br.com.laudosmama.repository.data

sealed class Error {
    object DatabaseError : Error()

    object ItemNotFound : Error()

}
