package ru.kugnn.kotlineverywhere.adapter

import androidx.annotation.DrawableRes

sealed class Item()

class BigBannerItem(@DrawableRes val id: Int) : Item()
class SmallBannerItem(@DrawableRes val id: Int, val text: String) : Item()
class GridBannerItem(
    @DrawableRes val photo1: Int,
    @DrawableRes val photo2: Int,
    @DrawableRes val photo3: Int,
    @DrawableRes val photo4: Int
) : Item()