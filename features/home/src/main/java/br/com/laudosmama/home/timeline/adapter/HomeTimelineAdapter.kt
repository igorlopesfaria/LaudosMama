package br.com.laudosmama.home.timeline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.laudosmama.home.databinding.HomeTimelineItemBinding
import br.com.laudosmama.home.timeline.model.HomeTimeline
import kotlinx.android.extensions.LayoutContainer

class HomeTimelineAdapter(private val clickListenerDetail: ((HomeTimeline) -> Unit),
                          private val clickListenerAttachment: ((HomeTimeline) -> Unit),
                          private val clickListenerShowLabs: (() -> Unit)) :
    RecyclerView.Adapter<HomeTimelineAdapter.HomeTimelineViewHolder>() {

    private val items = mutableListOf<HomeTimeline>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTimelineViewHolder {
        val itemBinding =
            HomeTimelineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  HomeTimelineViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: HomeTimelineViewHolder, position: Int) =
        viewHolder.bind(items[position], clickListenerDetail, clickListenerAttachment,
            clickListenerShowLabs, position, items.size)

    override fun getItemCount() = items.size

    fun setAllItems(list: List<HomeTimeline>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class HomeTimelineViewHolder(private val itemBinding: HomeTimelineItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), LayoutContainer {

        override val containerView: View
            get() = itemView

        fun bind(item: HomeTimeline, detail: ((HomeTimeline) -> Unit), attach: ((HomeTimeline) -> Unit), showLabs: (() -> Unit), position: Int, size: Int) {
            if(position == 0) {
                itemBinding.lineBeforeGray.visibility = View.GONE
                itemBinding.lineBeforePurple.visibility = View.GONE
            }

            if (position == size -1) {
                itemBinding.lineNextGray.visibility = View.GONE
                itemBinding.lineNextPurple.visibility = View.GONE
            }

            if (position % 2 == 0)
                itemBinding.shouldIndicateLabImageView.visibility = View.GONE

            itemBinding.attachImageView.setOnClickListener {
                attach(item)
            }

            itemBinding.shouldIndicateLabImageView.setOnClickListener {
                showLabs()
            }
            itemView.setOnClickListener {
                detail(item)
            }
        }
    }
}
