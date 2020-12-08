package br.com.laudosmama.repository.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.Exception
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <RemoteType> fetchRemote(
    loadRemote: suspend () -> RemoteType
): Flow<Result<RemoteType>> {
    return flow {
        try {
            Log.i("StateFlow", "Loading Repository")
            emit(Result.Loading)
            Log.i("StateFlow", "Success Repository")
            emit(Result.Success(loadRemote()))
        } catch (exception: Exception) {
            Log.e("StateFlow", "Failure Repository"+exception.message+" "+exception.cause)
            emit(Result.Failure(handleRemoteError(exception)))
        }
    }
}

suspend fun <EntityType> fetchLocal(
    loadLocal: suspend () -> EntityType
): Flow<Result<EntityType>> {
    return flow {
        try {
            Log.i("StateFlow", "Loading Repository")
            emit(Result.Loading)
            Log.i("StateFlow", "Success Repository")
            emit(Result.Success(loadLocal()))
        } catch (exception: Exception) {
            Log.i("StateFlow", "Failure Repository"+exception.message+" "+exception.cause)
            emit(Result.Failure(Error.DatabaseError(exception)))
        }
    }
}


private fun handleRemoteError(exception: Exception): Error =
    if (exception is HttpException) {
        Error.ServerError(data = exception)
    } else if (exception is SocketTimeoutException || exception is UnknownHostException) {
        Error.NetworkError
    } else {
        Error.UnknownError
    }
