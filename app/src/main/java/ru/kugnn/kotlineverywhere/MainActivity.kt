package ru.kugnn.kotlineverywhere

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.banner_big.*
import kotlinx.android.synthetic.main.banner_grid.*
import kotlinx.android.synthetic.main.banner_small.*
import kotlinx.android.synthetic.main.box.view.*
import ru.kugnn.kotlineverywhere.adapter.*

class MainActivity : AppCompatActivity() {

    private val bannerAdapter = adapter {
        delegate<BigBannerItem>(R.layout.banner_big) {

            click {
                Toast.makeText(this@MainActivity, "BIG BANNER CLICKED", LENGTH_SHORT).show()
            }

            bind {
                it.id into bigBannerImage
            }
        }

        delegate<SmallBannerItem>(R.layout.banner_small) {

            click {
                item?.let {
                    Toast.makeText(this@MainActivity, it.text, LENGTH_SHORT).show()
                }
            }

            bind {
                it.id into smallBannerImage
                smallBannerLabel.text = it.text
            }
        }

        delegate<GridBannerItem>(R.layout.banner_grid) {
            bind {
                it.photo1 into box1.boxImage
                it.photo2 into box2.boxImage
                it.photo3 into box3.boxImage
                it.photo4 into box4.boxImage
            }
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
