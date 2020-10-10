package br.com.laudosmama.onboarding.resetpassword.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.features.onboarding.databinding.OnboardingFragmentResetPasswordBinding

class ResetPasswordFragment: BaseFragment() {
    private lateinit var binding: OnboardingFragmentResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingFragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setSupportActionBar(binding.toolbar)
        (activity as BaseActivity).supportActionBar?.title = null
    }

}
