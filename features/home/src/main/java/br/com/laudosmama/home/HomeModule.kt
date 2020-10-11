package br.com.laudosmama.home

import br.com.laudosmama.home.profile.viewmodel.HomeProfileViewModel
import br.com.laudosmama.home.timeline.viewmodel.HomeTimelineViewModel
import br.com.laudosmama.repository.account.AccountRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { provideHomeProfileViewModel(get()) }
    viewModel { provideHomeTimelineViewModel() }
}

fun provideHomeTimelineViewModel(): HomeTimelineViewModel {
    return HomeTimelineViewModel()
}

fun provideHomeProfileViewModel(accountRepository: AccountRepository): HomeProfileViewModel {
    return HomeProfileViewModel(accountRepository)
}
