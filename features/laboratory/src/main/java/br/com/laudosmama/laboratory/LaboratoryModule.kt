package br.com.laudosmama.laboratory

import br.com.laudosmama.laboratory.list.viewmodel.LaboratoryListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val laboratoryModule = module {
    viewModel { provideLaboratoryListViewModel() }
}

fun provideLaboratoryListViewModel(): LaboratoryListViewModel {
    return LaboratoryListViewModel()
}
