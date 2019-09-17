package ru.kugnn.kotlineverywhere.adapter

import android.view.ViewGroup

inline fun <reified T : Item> createDelegate(
    layoutId: Int,
    crossinline block: BaseHolder<T>.() -> Unit
): AdapterDelegate<T> {
    return object : AdapterDelegate<T> {
        override fun canHandle(item: Item): Boolean = item is T
        override fun createViewHolder(parent: ViewGroup): BaseHolder<T> =
            BaseHolder<T>(parent, layoutId)
                .also {
                    block(it)
                }
    }
}

inline fun <reified T : Item> BaseAdapter.delegate(
    layoutId: Int,
    crossinline block: BaseHolder<T>.() -> Unit
) {
    @Suppress("UNCHECKED_CAST")
    addDelegate(createDelegate(layoutId, block) as AdapterDelegate<Item>)
}

fun adapter(lambda: BaseAdapter.() -> Unit): BaseAdapter = BaseAdapter().also { lambda(it) }