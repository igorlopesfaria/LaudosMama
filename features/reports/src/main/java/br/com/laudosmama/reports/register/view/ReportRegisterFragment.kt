package br.com.laudosmama.reports.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.reports.databinding.ReportRegisterFragmentBinding
import br.com.laudosmama.reports.register.viewmodel.ReportViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ReportRegisterFragment : BaseFragment() {

    private lateinit var binding: ReportRegisterFragmentBinding
    private val viewModel: ReportViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ReportRegisterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
