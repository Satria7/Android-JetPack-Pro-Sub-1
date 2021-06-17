package com.satria.jpro.firstsubmission.ui.detail
//copyright satria//
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.satria.jpro.firstsubmission.R
//copyright satria//
import com.satria.jpro.firstsubmission.model.DataModel
import com.satria.jpro.firstsubmission.utils.Helper.TYPE_MOVIE
import com.satria.jpro.firstsubmission.utils.Helper.TYPE_TVSHOW
import com.satria.jpro.firstsubmission.utils.Helper.setImageWithGlide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
//copyright satria//


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val viewModel = ViewModelProvider(
            this@DetailActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        setupToolbar()

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))
            id?.let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))
            id?.let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        tv_detail_name.text = result.name
        tv_detail_desc.text = result.desc
        setImageWithGlide(this@DetailActivity, result.poster, img_detail_poster)
        setImageWithGlide(this@DetailActivity, result.img_preview, img_detail_hightlight)
    }

    private fun setupToolbar() {
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    private fun setupToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}


//copyright satria//