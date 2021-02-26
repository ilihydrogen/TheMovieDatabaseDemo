package ru.mikhailskiy.intensiv.ui.tvshows

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.tv_show_item.*
import ru.mikhailskiy.intensiv.R
import ru.mikhailskiy.intensiv.data.Movie
import ru.mikhailskiy.intensiv.extensions.loadByUrl
import ru.mikhailskiy.intensiv.network.ImageUtils

class TVShowItem(private val content: Movie, private val onClick: ((movie: Movie) -> Unit)? = null) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.tv_show_title.text = content.title
        viewHolder.tv_show_rating.rating = content.rating
        viewHolder.tv_show_image.loadByUrl(ImageUtils.imageUrl(content.posterPath?: "#"))
        viewHolder.itemView.setOnClickListener { onClick?.invoke(content) }
    }

    override fun getLayout(): Int {
        return R.layout.tv_show_item
    }

}