package com.doubtnutapp.ui.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pankaj.movieapp.R
import com.pankaj.movieapp.data.model.ComingSoon
import com.pankaj.movieapp.data.model.MovieInTheatres
import com.pankaj.movieapp.databinding.ItemComingSoonBinding
import kotlinx.android.synthetic.main.item_coming_soon.view.*

class MovieinTheaterAdapter :
    RecyclerView.Adapter<MovieinTheaterAdapter.ViewHolder>() {

    var movieData: List<MovieInTheatres> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate<com.pankaj.movieapp.databinding.ItemMovieInTheaterBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_movie_in_theater, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieData!![position])

    }


    override fun getItemCount(): Int {
        return movieData?.size ?: 0
    }

    class ViewHolder constructor(var binding: com.pankaj.movieapp.databinding.ItemMovieInTheaterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(commingSoon: MovieInTheatres) {
            binding.movieintheater = commingSoon
            binding.executePendingBindings()
            binding.root.title.text = commingSoon.title
            binding.root.rating.text = "rating : " + commingSoon.averageRating
            binding.root.yearrelease.text = "rating : " + commingSoon.year


        }


    }

    fun updateData(movieData: List<MovieInTheatres>) {
        this.movieData = movieData
        notifyDataSetChanged()
    }


}