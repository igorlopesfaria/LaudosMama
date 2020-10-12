package br.com.laudosmama.laboratory.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.laboratory.databinding.LaboratoryListFragmentBinding
import br.com.laudosmama.laboratory.list.adapter.LaboratoryListAdapter
import br.com.laudosmama.laboratory.list.model.LaboratoryItem
import br.com.laudosmama.laboratory.list.viewmodel.LaboratoryListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LaboratoryListFragment : BaseFragment() {

    private lateinit var binding: LaboratoryListFragmentBinding
    private val viewModel: LaboratoryListViewModel by viewModel()

    private val adapter = LaboratoryListAdapter(::onClickCall)

    private fun onClickCall(laboratoryItem: LaboratoryItem) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LaboratoryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timeLine.adapter = adapter
        adapter.setAllItems(
            listOf(
                LaboratoryItem(),
                LaboratoryItem(),
                LaboratoryItem(),
                LaboratoryItem(),
                LaboratoryItem(),
                LaboratoryItem()
            )
        )
    }

}
