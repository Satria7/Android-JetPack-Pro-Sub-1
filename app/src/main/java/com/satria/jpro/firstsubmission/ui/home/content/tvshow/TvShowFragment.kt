package com.satria.jpro.firstsubmission.ui.home.content.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satria.jpro.firstsubmission.R
import com.satria.jpro.firstsubmission.model.DataModel
import com.satria.jpro.firstsubmission.ui.detail.DetailActivity
import com.satria.jpro.firstsubmission.ui.home.HomeViewModel
import com.satria.jpro.firstsubmission.ui.home.content.DataAdapter
import com.satria.jpro.firstsubmission.ui.home.content.DataCallback
import com.satria.jpro.firstsubmission.utils.Helper.TYPE_TVSHOW
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * Satria Junanda
 */
class TvShowFragment : Fragment(),
    DataCallback {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listTvShow = viewModel.getListTvShow()
        setupRecyclerView(listTvShow)
    }

    private fun setupRecyclerView(data: List<DataModel>) {
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@TvShowFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is DataAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}
