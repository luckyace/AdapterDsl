package ru.kugnn.kotlineverywhere.adapter

import android.view.ViewGroup
import kotlinx.android.synthetic.main.banner_big.*
import kotlinx.android.synthetic.main.banner_grid.*
import kotlinx.android.synthetic.main.banner_small.*
import kotlinx.android.synthetic.main.box.view.*
import ru.kugnn.kotlineverywhere.R

class BannerAdapter : BaseAdapter() {
    init {
        addDelegate(BigBannerAdapterDelegate())
        addDelegate(SmallBannerAdapterDelegate())
        addDelegate(GridBannerAdapterDelegate())
    }
}

class BigBannerAdapterDelegate : AdapterDelegate {
    override fun canHandle(item: Item): Boolean = item is BigBannerItem
    override fun createViewHolder(parent: ViewGroup): BaseHolder =
        object : BaseHolder(parent, R.layout.banner_big) {
            override fun bind(item: Item) {
                item as BigBannerItem
                item.id into bigBannerImage
            }
        }
}


class SmallBannerAdapterDelegate : AdapterDelegate {
    override fun canHandle(item: Item): Boolean = item is SmallBannerItem
    override fun createViewHolder(parent: ViewGroup): BaseHolder =
        object : BaseHolder(parent, R.layout.banner_small) {
            override fun bind(item: Item) {
                item as SmallBannerItem
                item.id into smallBannerImage
                smallBannerLabel.text = item.text
            }
        }
}

class GridBannerAdapterDelegate : AdapterDelegate {
    override fun canHandle(item: Item): Boolean = item is GridBannerItem
    override fun createViewHolder(parent: ViewGroup): BaseHolder =
        object : BaseHolder(parent, R.layout.banner_grid) {
            override fun bind(item: Item) {
                item as GridBannerItem
                item.photo1 into box1.boxImage
                item.photo2 into box2.boxImage
                item.photo3 into box3.boxImage
                item.photo4 into box4.boxImage
            }
        }
}