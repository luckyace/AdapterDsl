package ru.kugnn.kotlineverywhere

import ru.kugnn.kotlineverywhere.adapter.BigBannerItem
import ru.kugnn.kotlineverywhere.adapter.GridBannerItem
import ru.kugnn.kotlineverywhere.adapter.SmallBannerItem

fun loadData() =
    listOf(
        BigBannerItem(R.drawable.android_logo_big),
        SmallBannerItem(R.drawable.android_logo_small, "hello!"),
        GridBannerItem(
            R.drawable.kotlin_logo_4,
            R.drawable.kotlin_logo_2,
            R.drawable.kotlin_logo_3,
            R.drawable.kotlin_logo_4
        ),
        SmallBannerItem(R.drawable.kotlin_logo_1, "wow wow wow"),
        GridBannerItem(
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small
        ),
        BigBannerItem(R.drawable.android_logo_big),
        SmallBannerItem(R.drawable.android_logo_small, "random text"),
        SmallBannerItem(R.drawable.android_logo_small, "random text1"),
        SmallBannerItem(R.drawable.android_logo_small, "random text2"),
        SmallBannerItem(R.drawable.android_logo_small, "random text3"),
        SmallBannerItem(R.drawable.kotlin_logo_3, "random text4"),
        SmallBannerItem(R.drawable.android_logo_small, "random text5"),
        SmallBannerItem(R.drawable.android_logo_small, "random text6"),
        SmallBannerItem(R.drawable.kotlin_logo_1, "random text7"),
        SmallBannerItem(R.drawable.kotlin_logo_1, "yes yes yes"),
        GridBannerItem(
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small,
            R.drawable.android_logo_small
        )
    )