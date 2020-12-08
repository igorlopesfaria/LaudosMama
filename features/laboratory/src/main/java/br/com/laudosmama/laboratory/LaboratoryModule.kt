package br.com.laudosmama.laboratory

import br.com.laudosmama.laboratory.list.viewmodel.LaboratoryListViewModel
import br.com.laudosmama.repository.laboratory.LaboratoryRepository
import br.com.laudosmama.repository.laboratory.LaboratoryRepositoryImpl
import br.com.laudosmama.repository.remote.service.LaboratoryService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val laboratoryModule = module {
    single { provideLaboratoryService(get(named("default"))) }
    single { provideLaboratoryRepository(get()) }
    viewModel { provideLaboratoryListViewModel(get()) }
}

fun provideLaboratoryListViewModel(laboratoryRepository: LaboratoryRepository): LaboratoryListViewModel =
    LaboratoryListViewModel(laboratoryRepository)

fun provideLaboratoryRepository(service: LaboratoryService): LaboratoryRepository =
    LaboratoryRepositoryImpl(service)

fun provideLaboratoryService(retrofit: Retrofit): LaboratoryService =
    retrofit.create(LaboratoryService::class.java)
