package br.com.laudosmama.laboratory.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.laudosmama.laboratory.R
import br.com.laudosmama.laboratory.databinding.LaboratoryItemBinding
import br.com.laudosmama.laboratory.list.model.LaboratoryItem
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
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
            val  hierarchy =
            GenericDraweeHierarchyBuilder.newInstance(itemBinding.root.context.resources)
                .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                .setPlaceholderImage(R.drawable.ic_baseline_image_24)
            itemBinding.photoImageView.hierarchy = hierarchy.build()
            itemBinding.photoImageView.setImageURI(
                item.logoImage
            )
            itemBinding.nameTextView.text = item.name
            itemBinding.addressTextView.text = item.address
            itemBinding.distanceTextView.text = item.distance

            itemBinding.phoneImageView.setOnClickListener {
                listener(item)
            }
        }
    }
}
