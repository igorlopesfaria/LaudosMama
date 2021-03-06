package br.com.laudosmama.onboarding.login.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.features.onboarding.databinding.OnboardingFragmentLoginBinding


class LoginFragment: BaseFragment() {
    private lateinit var binding: OnboardingFragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingFragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setSupportActionBar(binding.toolbar)
        (activity as BaseActivity).supportActionBar?.title = null
        setupListeners()
    }

    private fun setupListeners() {
        binding.loginButton.setOnClickListener {
            val intent = Intent(
                requireContext(),
                Class.forName("br.com.laudosmama.home.HomeActivity")
            )
            activity?.finish()
            startActivity(intent)
        }

        binding.forgotPasswordTextView.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                LoginFragmentDirections.actionResetPassword()
            )
        }

        binding.registerButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                LoginFragmentDirections.actionRegister()
            )
        }
    }


}
