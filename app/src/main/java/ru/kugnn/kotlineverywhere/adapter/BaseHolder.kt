package ru.kugnn.kotlineverywhere.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.kugnn.kotlineverywhere.inflate

class BaseHolder<T : Item>(parent: ViewGroup, layoutId: Int) :
    RecyclerView.ViewHolder(parent.inflate(layoutId)), LayoutContainer {

    private var innerItem: T? = null
    val item: T?
        get() = innerItem

    private var bind: ((T) -> Unit)? = null

    override val containerView: View?
        get() = itemView

    internal fun onBind(item: T) {
        this.innerItem = item
        bind?.invoke(item)
    }

    fun bind(bind: (T) -> Unit) {
        this.bind = bind
    }

    fun click(onClick: () -> Unit) {
        itemView.setOnClickListener {
            onClick()
        }
    }
}
