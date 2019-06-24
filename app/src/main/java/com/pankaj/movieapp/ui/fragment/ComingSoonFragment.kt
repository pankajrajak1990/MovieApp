package com.doubtnutapp.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pankaj.movieapp.R
import com.pankaj.movieapp.RecyclerItemClickListener
import com.pankaj.movieapp.addOnItemClick
import com.pankaj.movieapp.data.Outcome
import com.pankaj.movieapp.ui.activity.DetailsActivity
import com.pankaj.movieapp.ui.viewModel.ComingSoonViewModel
import kotlinx.android.synthetic.main.fragment_comingsoon.*


class ComingSoonFragment : Fragment() {

    companion object {
        fun newInstance() = ComingSoonFragment()

    }

    private lateinit var viewModel: ComingSoonViewModel
    private lateinit var adapter: ComingSoonAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comingsoon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ComingSoonViewModel::class.java)
        fetchMovies()
        adapter = ComingSoonAdapter()
        rvComingSoon.layoutManager = LinearLayoutManager(activity!!)
        rvComingSoon.adapter = adapter
        rvComingSoon.addOnItemClick(object : RecyclerItemClickListener.OnClickListener {
            override fun onItemClick(position: Int, view: View) {
                val intent  = DetailsActivity.startActivity(activity!!, adapter.movieData[position].id,  adapter.movieData[position].title, adapter.movieData[position].averageRating, adapter.movieData[position].year, adapter.movieData[position].posterUrl, adapter.movieData[position].posterUrl)
                    startActivity(intent)
            }
        })

    }

    private fun fetchMovies() {
        viewModel.getMovies().observe(this, Observer { response ->
            when (response) {
                is Outcome.Progress -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Outcome.Failure -> {
                    progressBar.visibility = View.GONE
                }
                is Outcome.ApiError -> {
                    progressBar.visibility = View.GONE

                }
                is Outcome.Success -> {
                    val comingSoonData = response.data.comingSoon
                    adapter.updateData(comingSoonData)
                    progressBar.visibility = View.GONE
                }
            }
        })
    }


}
