package br.com.laudosmama.laboratory.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.laudosmama.laboratory.databinding.LaboratoryItemBinding
import br.com.laudosmama.laboratory.list.model.LaboratoryItem
import kotlinx.android.extensions.LayoutContainer


class LaboratoryListAdapter(private val clickListener: ((LaboratoryItem) -> Unit)) :
    RecyclerView.Adapter<LaboratoryListAdapter.LaboratoryItemViewHolder>() {

    private val items = mutableListOf<LaboratoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaboratoryItemViewHolder {
        val itemBinding =
            LaboratoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  LaboratoryItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: LaboratoryItemViewHolder, position: Int) =
        viewHolder.bind(items[position], clickListener)

    override fun getItemCount() = items.size

    fun setAllItems(list: List<LaboratoryItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class LaboratoryItemViewHolder(private val itemBinding: LaboratoryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bind(
            item: LaboratoryItem,
            listener: ((LaboratoryItem) -> Unit),
        ) {
            itemBinding.photoImageView.setImageURI(
                "https://pbs.twimg.com/profile_images/1134189808564219904/p3ORVqTV_400x400.png"
            )

            itemBinding.phoneImageView.setOnClickListener {
                listener(item)
            }
        }
    }
}
