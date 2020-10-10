package br.com.laudosmama.onboarding.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.features.onboarding.databinding.OnboardingFragmentWelcomeBinding

class WelcomeFragment : BaseFragment(){
    private lateinit var binding: OnboardingFragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingFragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }
    private fun setupListeners() {
        binding.loginButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                WelcomeFragmentDirections.actionLogin()
            )
        }
        binding.registerButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                WelcomeFragmentDirections.actionRegister()
            )
        }
    }
}