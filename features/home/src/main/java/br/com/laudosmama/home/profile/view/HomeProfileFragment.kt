package br.com.laudosmama.home.profile.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.home.R
import br.com.laudosmama.home.databinding.HomeProfileFragmentBinding
import br.com.laudosmama.home.profile.viewmodel.HomeProfileViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeProfileFragment : BaseFragment() {

    private lateinit var binding: HomeProfileFragmentBinding
    private val viewModel: HomeProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
