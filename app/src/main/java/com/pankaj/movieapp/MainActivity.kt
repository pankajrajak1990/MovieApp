package com.pankaj.movieapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.doubtnutapp.ui.course.ComingSoonFragment
import com.doubtnutapp.ui.course.IndianMovieFragment
import com.doubtnutapp.ui.course.MovieInTheaterFragment

class MainActivity : AppCompatActivity() {

    private val COMING_SOON_FRAGMENT = "coming_soon_fragment"

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(ComingSoonFragment.newInstance(), COMING_SOON_FRAGMENT)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(MovieInTheaterFragment.newInstance(), COMING_SOON_FRAGMENT)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                replaceFragment(IndianMovieFragment.newInstance(), COMING_SOON_FRAGMENT)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().add(R.id.container, ComingSoonFragment.newInstance()).commit()

    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        ft.replace(R.id.container, fragment, tag)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()
    }
}
