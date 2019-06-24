package com.doubtnutapp.ui.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pankaj.movieapp.R
import com.pankaj.movieapp.data.model.ComingSoon
import com.pankaj.movieapp.databinding.ItemComingSoonBinding
import kotlinx.android.synthetic.main.item_coming_soon.view.*

class ComingSoonAdapter :
    RecyclerView.Adapter<ComingSoonAdapter.ViewHolder>() {

    var movieData: List<ComingSoon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate<com.pankaj.movieapp.databinding.ItemComingSoonBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_coming_soon, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieData!![position])

    }


    override fun getItemCount(): Int {
        return movieData?.size ?: 0
    }

    class ViewHolder constructor(var binding: ItemComingSoonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(commingSoon: ComingSoon) {
            binding.comingSoon = commingSoon
            binding.executePendingBindings()
            binding.root.title.text = commingSoon.title
            binding.root.rating.text = "rating : " + commingSoon.averageRating
            binding.root.yearrelease.text = "rating : " + commingSoon.year


        }


    }

    fun updateData(movieData: List<ComingSoon>) {
        this.movieData = movieData
        notifyDataSetChanged()
    }


}