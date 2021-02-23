package ru.mikhailskiy.intensiv.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.movie_details_fragment.*
import ru.mikhailskiy.intensiv.R
import ru.mikhailskiy.intensiv.data.Genre
import ru.mikhailskiy.intensiv.data.Movie
import ru.mikhailskiy.intensiv.data.repository.MovieRepository
import ru.mikhailskiy.intensiv.extensions.loadByUrl
import ru.mikhailskiy.intensiv.extensions.toast
import ru.mikhailskiy.intensiv.network.ImageUtils

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MovieDetailsFragment : Fragment() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = Gson().fromJson(it.getString("movie"), Movie::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.movie_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MovieRepository.movieDetails(
            id = movie.id,
            onResult = { this.movie = it; updateDetails() },
            onError = { context?.toast(it) })
        MovieRepository.movieCredits(
            id = movie.id,
            onResult = { this.movie.actors = it.cast; updateDetails() },
            onError = { context?.toast(it) })

        updateDetails()
    }

    private fun updateDetails() {
        movie_title.text = movie.title
        movie_description.text = movie.overview
        movie_year.text = movie.year
        movie_image.loadByUrl(ImageUtils.imageUrl(movie.posterPath))
        movie_genre.text = movie.genres?.let { Genre.getGenresAsString(it) }
        movie_studio.text = movie.production?.last()?.name
        movie_cast.adapter = GroupAdapter<GroupieViewHolder>().apply {
            movie.actors?.map {
                CastItem(it.name, ImageUtils.imageUrl(it.profilePath ?: "#"))
            }?.toList()?.let { addAll(it) }
        }
        movie_cast.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}