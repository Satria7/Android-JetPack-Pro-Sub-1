package com.satria.jpro.firstsubmission.ui.home
//copyright satria//
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.satria.jpro.firstsubmission.R
import com.satria.jpro.firstsubmission.ui.home.content.movie.MovieFragment
import com.satria.jpro.firstsubmission.ui.home.content.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Satria Junanda
 */

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(
            this@HomeActivity,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]

        setupToolbar()
        setupBottomNavBar()

        btnInfo.setOnClickListener {
            Toast.makeText(this@HomeActivity, "Submision Pertama by Satria Junanda", Toast.LENGTH_SHORT).show();
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.elevation = 8F
    }

    private fun setupBottomNavBar() {
        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()

        setActiveFragment(movieFragment, resources.getString(R.string.tab_title_movie))

        bottom_navbar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setActiveFragment(
                    movieFragment,
                    resources.getString(R.string.tab_title_kosong)
                )
                R.id.nav_tvshow -> setActiveFragment(
                    tvShowFragment,
                    resources.getString(R.string.tab_title_kosong)
                )
            }
        }
    }

    private fun setActiveFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}
//copyright satria//