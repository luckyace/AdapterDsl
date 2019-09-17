package ru.kugnn.kotlineverywhere.adapter

import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.kugnn.kotlineverywhere.inflate

abstract class BaseAdapter : RecyclerView.Adapter<BaseHolder>() {

    private val delegates = SparseArray<AdapterDelegate>()

    private var list: List<Item> = emptyList()

    fun setItems(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addDelegate(delegate: AdapterDelegate) {
        delegates.put(delegates.size(), delegate)
    }

    override fun getItemViewType(position: Int): Int {

        delegates.forEach { key, value ->
            if (value.canHandle(list[position])) {
                return key
            }
        }

        throw RuntimeException("Can't find delegate to handle this item type!")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return delegates.get(viewType).createViewHolder(parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.bind(list[position])
    }
}

abstract class BaseHolder(parent: ViewGroup, layoutId: Int) :
    RecyclerView.ViewHolder(parent.inflate(layoutId)), LayoutContainer {

    override val containerView: View?
        get() = itemView

    abstract fun bind(item: Item)
}
