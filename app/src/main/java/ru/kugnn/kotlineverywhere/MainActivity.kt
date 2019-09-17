package ru.kugnn.kotlineverywhere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.banner_big.view.*
import kotlinx.android.synthetic.main.banner_grid.view.*
import kotlinx.android.synthetic.main.banner_small.view.*
import kotlinx.android.synthetic.main.box.view.*
import ru.kugnn.kotlineverywhere.adapter.*

class MainActivity : AppCompatActivity() {

    private val bannerAdapter = adapter {
        delegate<BigBannerItem>(R.layout.banner_big) { itemView, item ->
            item.id into itemView.bigBannerImage
        }
        delegate<SmallBannerItem>(R.layout.banner_small) { itemView, item ->
            item.id into itemView.smallBannerImage
            itemView.smallBannerLabel.text = item.text
        }
        delegate<GridBannerItem>(R.layout.banner_grid) { itemView, item ->
            item.photo1 into itemView.box1.boxImage
            item.photo2 into itemView.box2.boxImage
            item.photo3 into itemView.box3.boxImage
            item.photo4 into itemView.box4.boxImage
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = bannerAdapter
        }

        bannerAdapter.setItems(loadData())
    }
}
