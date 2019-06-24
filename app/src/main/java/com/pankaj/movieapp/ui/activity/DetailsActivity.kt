package com.pankaj.movieapp.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pankaj.movieapp.R
import kotlinx.android.synthetic.main.details_activity.*

class DetailsActivity : AppCompatActivity() {


    companion object {

        private const val INTENT_EXTRA_ID = "id"
        private const val INTENT_EXTRA_TITTLE = "title"
        private const val INTENT_EXTRA_RATING = "rating"
        private const val INTENT_EXTRA_RELEASE_YEAR = "year"
        private const val INTENT_EXTRA_URL = "url"
        private const val INTENT_EXTRA_STORYLINE = "storyline"

        fun startActivity(
            context: Context,
            id: String,
            tittle: String,
            rating: String,
            year: String,
            url: String,
            storyLine: String
        ): Intent {

            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(INTENT_EXTRA_ID, id)
                putExtra(INTENT_EXTRA_TITTLE, tittle)
                putExtra(INTENT_EXTRA_RATING, rating)
                putExtra(INTENT_EXTRA_RELEASE_YEAR, year)
                putExtra(INTENT_EXTRA_URL, url)
                putExtra(INTENT_EXTRA_STORYLINE, storyLine)

            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        setIntentData()

    }

    private fun setIntentData() {
        tvStoryLine.text = intent.getStringExtra(INTENT_EXTRA_TITTLE)
        tvyear.text = "Year : "+ intent.getStringExtra(INTENT_EXTRA_RELEASE_YEAR)
        tvId.text = "Id : "+ intent.getStringExtra(INTENT_EXTRA_ID)
        tvRating .text = "Rating : "+ intent.getStringExtra(INTENT_EXTRA_RATING)
        tvTittle.text = intent.getStringExtra(INTENT_EXTRA_TITTLE)

        val imageUrl = intent.getStringExtra(INTENT_EXTRA_URL) ?: ""
        Glide.with(this)
            .load(imageUrl)
            .into(ivPost)
    }


}
