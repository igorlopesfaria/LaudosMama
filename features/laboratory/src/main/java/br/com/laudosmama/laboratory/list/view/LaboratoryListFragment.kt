package br.com.laudosmama.laboratory.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.laboratory.databinding.LaboratoryListFragmentBinding
import br.com.laudosmama.laboratory.list.adapter.LaboratoryListAdapter
import br.com.laudosmama.laboratory.list.model.LaboratoryItem
import br.com.laudosmama.laboratory.list.state.LaboratoryListUiState
import br.com.laudosmama.laboratory.list.viewmodel.LaboratoryListViewModel
import kotlinx.coroutines.flow.collect
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
    ): View {
        binding = LaboratoryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.laboratoryList.adapter = adapter
        setupFlow()
        setupListeners()
        viewModel.listLaboratories()
    }

    private fun setupListeners() {
        binding.errorView.setButtonOnClickListener {
            viewModel.listLaboratories()
        }
    }

    private fun setupFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.stateListLaboratory.collect { uiState ->
                when(uiState){
                   is LaboratoryListUiState.Success -> showList(uiState.listLaboratoryItem)
                   is LaboratoryListUiState.Empty -> showEmpty()
                   is LaboratoryListUiState.ServerError -> showError()
                   is LaboratoryListUiState.Loading -> showLoading()
                   else -> Unit
                }
            }
        }
    }

    private fun showList(listLaboratoryItem: List<LaboratoryItem>) {
        binding.laboratoryList.visibility = View.VISIBLE
        binding.loadingView.visibility = View.GONE
        adapter.setAllItems(listLaboratoryItem)
        binding.emptyView.visibility = View.GONE
        binding.errorView.visibility = View.GONE
    }

    private fun showLoading() {
        binding.laboratoryList.visibility = View.GONE
        binding.loadingView.visibility = View.VISIBLE
        binding.emptyView.visibility = View.GONE
        binding.errorView.visibility = View.GONE
    }

    private fun showError() {
        binding.laboratoryList.visibility = View.GONE
        binding.loadingView.visibility = View.GONE
        binding.emptyView.visibility = View.GONE
        binding.errorView.visibility = View.VISIBLE
    }

    private fun showEmpty() {
        binding.laboratoryList.visibility = View.GONE
        binding.loadingView.visibility = View.GONE
        binding.emptyView.visibility = View.VISIBLE
        binding.errorView.visibility = View.GONE
    }

}
