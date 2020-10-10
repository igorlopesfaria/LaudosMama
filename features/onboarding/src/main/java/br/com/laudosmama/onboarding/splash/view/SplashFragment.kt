package br.com.laudosmama.onboarding.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.features.onboarding.databinding.OnboardingFragmentSplashBinding
import br.com.laudosmama.onboarding.splash.model.SplashAccount
import br.com.laudosmama.onboarding.splash.viewmodel.SplashViewModel
import br.com.laudosmama.repository.data.Result
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment() {
    private lateinit var binding: OnboardingFragmentSplashBinding
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingFragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadAccountCredentials()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.accountLiveData.observe(viewLifecycleOwner, {
            handleNavigation(it)
        })
    }

    private fun handleNavigation(result: Result<SplashAccount>) {
        when (result) {
            is Result.Success -> {
                verifyValidation(result.data)
            }
            is Result.Failure -> {
                goToWelcome()
            }
        }
    }

    private fun verifyValidation(splashAccount: SplashAccount) {
        if(!splashAccount.validated) {
            goToWelcome()
        }
    }

    private fun goToWelcome(){
        NavHostFragment.findNavController(this).navigate(
            SplashFragmentDirections.actionWelcome()
        )
    }
}
