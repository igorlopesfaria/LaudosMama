package br.com.laudosmama.repository.remote.service

import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import retrofit2.http.GET

interface LaboratoryService {

    @GET("/laboratory?currentPage=0&pageSize=100")
    suspend fun fetchLaboratories(): List<LaboratoryItemResponse>
}