package ru.kugnn.kotlineverywhere.adapter

import android.view.ViewGroup

interface AdapterDelegate<T : Item> {
    fun canHandle(item: Item): Boolean
    fun createViewHolder(parent: ViewGroup): BaseHolder<T>
}