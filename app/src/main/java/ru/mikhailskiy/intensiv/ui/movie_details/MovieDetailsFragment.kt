package ru.mikhailskiy.intensiv.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.movie_details_fragment.*
import ru.mikhailskiy.intensiv.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MovieDetailsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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

        movie_cast.adapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(
                listOf(
                    CastItem(
                        "Robert \"Bob\" Paulson",
                        "https://avatars.yandex.net/get-music-content/3071110/7d4e99c1.p.5435146/200x200"
                    ),
                    CastItem(
                        "Helena Bonham Carter",
                        "https://avatars.yandex.net/get-music-content/3071110/7d4e99c1.p.5435146/200x200"
                    ),
                    CastItem(
                        "Bread Pitt",
                        "https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/12/homemade-artisan-bread-600x900.jpg"
                    )
                )
            )
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