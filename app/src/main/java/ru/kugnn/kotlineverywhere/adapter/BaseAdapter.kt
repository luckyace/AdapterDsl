package ru.kugnn.kotlineverywhere.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter : RecyclerView.Adapter<BaseHolder<Item>>() {

    private val delegates = SparseArray<AdapterDelegate<Item>>()

    private var list: List<Item> = emptyList()

    fun setItems(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addDelegate(delegate: AdapterDelegate<Item>) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<Item> {
        return delegates.get(viewType).createViewHolder(parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseHolder<Item>, position: Int) {
        holder.onBind(list[position])
    }
}

