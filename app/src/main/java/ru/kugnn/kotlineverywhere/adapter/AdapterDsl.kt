package ru.kugnn.kotlineverywhere.adapter

import android.view.View
import android.view.ViewGroup

inline fun <reified T : Item> createDelegate(
    layoutId: Int,
    crossinline bind: (View, T) -> Unit
): AdapterDelegate {
    return object : AdapterDelegate {
        override fun canHandle(item: Item): Boolean = item is T
        override fun createViewHolder(parent: ViewGroup): BaseHolder =
            object : BaseHolder(parent, layoutId) {
                override fun bind(item: Item) {
                    bind(itemView, item as T)
                }
            }
    }
}

inline fun <reified T : Item> BaseAdapter.delegate(
    layoutId: Int,
    crossinline bind: (View, T) -> Unit
) {
    addDelegate(createDelegate(layoutId, bind))
}

fun adapter(lambda: BaseAdapter.() -> Unit): BaseAdapter = BaseAdapter().also { lambda(it) }