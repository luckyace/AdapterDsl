package ru.kugnn.kotlineverywhere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.kugnn.kotlineverywhere.adapter.BannerAdapter

class MainActivity : AppCompatActivity() {

    val bannerAdapter = BannerAdapter()

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
