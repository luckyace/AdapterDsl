package ru.kugnn.kotlineverywhere

import ru.kugnn.kotlineverywhere.adapter.BigBannerItem
import ru.kugnn.kotlineverywhere.adapter.GridBannerItem
import ru.kugnn.kotlineverywhere.adapter.SmallBannerItem

fun loadData() =
    listOf(
        BigBannerItem(R.drawable.android_logo_big),
        SmallBannerItem(R.drawable.android_logo_small, "random text"),
        GridBannerItem(
            R.drawable.kotlin_logo_4,
            R.drawable.kotlin_logo_2,
            R.drawable.kotlin_logo_3,
            R.drawable.kotlin_logo_4
        ),
        SmallBannerItem(R.drawable.kotlin_logo_1, "random text"),
        GridBannerItem(
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small
        )
    )