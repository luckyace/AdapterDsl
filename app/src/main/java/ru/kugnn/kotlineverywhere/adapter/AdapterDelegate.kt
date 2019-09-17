package ru.kugnn.kotlineverywhere.adapter

import android.view.ViewGroup

interface AdapterDelegate {
    fun canHandle(item: Item) : Boolean
    fun createViewHolder(parent: ViewGroup) : BaseHolder
}