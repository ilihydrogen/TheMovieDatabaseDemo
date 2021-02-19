package ru.mikhailskiy.intensiv.ui.movie_details

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_cast.*
import ru.mikhailskiy.intensiv.R
import ru.mikhailskiy.intensiv.extensions.loadByUrl

class CastItem(private val name: String, private val imageUrl: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.item_name.text = name
        viewHolder.item_image.loadByUrl(imageUrl)
    }

    override fun getLayout(): Int {
        return R.layout.item_cast
    }

}