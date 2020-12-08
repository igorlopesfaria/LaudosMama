package br.com.laudosmama.repository.remote.service

import br.com.laudosmama.repository.remote.model.response.LaboratoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface LaboratoryService {

    @GET("/laboratory?currentPage=0&pageSize=100")
    suspend fun getLaboratories(): List<LaboratoryResponse>
}