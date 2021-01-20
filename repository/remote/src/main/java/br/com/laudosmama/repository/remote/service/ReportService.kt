package br.com.laudosmama.repository.remote.service

import br.com.laudosmama.repository.remote.model.request.ReportItemRegisterRequest
import br.com.laudosmama.repository.remote.model.request.ReportItemUpdateRequest
import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import br.com.laudosmama.repository.remote.model.response.ReportItemResponse
import retrofit2.http.*

interface ReportService {

    @GET("/report/{userId}&currentPage=0&pageSize=100")
    suspend fun fetchReports(
        @Path("userId") userId: String
    ): List<ReportItemResponse>

    @POST("/report")
    suspend fun insertReports(
        @Body reportItemRegisterRequest: ReportItemRegisterRequest
    ): ReportItemResponse

    @PUT("/report")
    suspend fun updateReports(
        @Body reportItemUpdateRequest: ReportItemUpdateRequest
    ): ReportItemResponse

}