package br.com.laudosmama.reports

import br.com.laudosmama.reports.register.viewmodel.ReportRegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val reportModule = module {
    viewModel { provideReportRegisterViewModel() }
}

fun provideReportRegisterViewModel(): ReportRegisterViewModel {
    return ReportRegisterViewModel()
}
