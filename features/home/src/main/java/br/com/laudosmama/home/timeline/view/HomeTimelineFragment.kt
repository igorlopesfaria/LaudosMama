package br.com.laudosmama.home.timeline.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.home.databinding.HomeTimelineFragmentBinding
import br.com.laudosmama.home.timeline.adapter.HomeTimelineAdapter
import br.com.laudosmama.home.timeline.model.HomeTimeline
import br.com.laudosmama.home.timeline.viewmodel.HomeTimelineViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeTimelineFragment : BaseFragment() {

    private lateinit var binding: HomeTimelineFragmentBinding
    private val viewModel: HomeTimelineViewModel by viewModel()

    private val adapter = HomeTimelineAdapter(::onClickDetail, ::onClickAttachment, ::onClickShowLab)

    private fun onClickDetail(homeTimeline: HomeTimeline) {
        val intent = Intent(
            requireContext(),
            Class.forName("br.com.laudosmama.reports.ReportActivity")
        )
        startActivity(intent)

    }

    private fun onClickAttachment(homeTimeline: HomeTimeline) {

    }
    private fun onClickShowLab() {
        val intent = Intent(
            requireContext(),
            Class.forName("br.com.laudosmama.laboratory.LaboratoryActivity")
        )
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeTimelineFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timeLine.adapter = adapter
        adapter.setAllItems(
            listOf(
                HomeTimeline(),
                HomeTimeline(),
                HomeTimeline(),
                HomeTimeline(),
                HomeTimeline(),
                HomeTimeline()
            )
        )
    }

}
