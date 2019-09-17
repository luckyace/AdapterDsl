package ru.kugnn.kotlineverywhere.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.banner_big.view.*
import kotlinx.android.synthetic.main.banner_grid.view.*
import kotlinx.android.synthetic.main.banner_small.view.*
import kotlinx.android.synthetic.main.box.view.*
import ru.kugnn.kotlineverywhere.R

class BannerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val BIG_BANNER_TYPE = 1
        const val SMALL_BANNER_TYPE = 2
        const val GRID_BANNER_TYPE = 3
    }

    private var list: List<Item> = emptyList()

    fun setItems(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is BigBannerItem -> BIG_BANNER_TYPE
            is SmallBannerItem -> SMALL_BANNER_TYPE
            is GridBannerItem -> GRID_BANNER_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BIG_BANNER_TYPE -> BigBannerHolder(parent)
            SMALL_BANNER_TYPE -> SmallBannerHolder(parent)
            GRID_BANNER_TYPE -> GridBannerHolder(parent)
            else -> throw AssertionError()
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (item) {
            is BigBannerItem -> (holder as BigBannerHolder).bind(item)
            is SmallBannerItem -> (holder as SmallBannerHolder).bind(item)
            is GridBannerItem -> (holder as GridBannerHolder).bind(item)
        }
    }
}

class BigBannerHolder(
    rootView: ViewGroup
) : RecyclerView.ViewHolder(rootView.inflate(R.layout.banner_big)) {

    fun bind(item: BigBannerItem) {
        item.id into itemView.bigBannerImage
    }
}

class SmallBannerHolder(
    rootView: ViewGroup
) : RecyclerView.ViewHolder(rootView.inflate(R.layout.banner_small)) {

    fun bind(item: SmallBannerItem) {
        item.id into itemView.smallBannerImage
        itemView.smallBannerLabel.text = item.text
    }
}

class GridBannerHolder(
    rootView: ViewGroup
) : RecyclerView.ViewHolder(rootView.inflate(R.layout.banner_grid)) {

    fun bind(item: GridBannerItem) = with(itemView) {
        item.photo1 into box1.boxImage
        item.photo2 into box2.boxImage
        item.photo3 into box3.boxImage
        item.photo4 into box4.boxImage
    }
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

infix fun Int.into(imageView: ImageView) {
    Glide.with(imageView.context).load(this).into(imageView)
}