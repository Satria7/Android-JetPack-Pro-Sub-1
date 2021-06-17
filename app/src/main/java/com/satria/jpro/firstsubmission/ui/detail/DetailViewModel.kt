package com.satria.jpro.firstsubmission.ui.detail
//copyright satria//
import androidx.lifecycle.ViewModel
import com.satria.jpro.firstsubmission.model.DataModel
import com.satria.jpro.firstsubmission.utils.DataDummy
//copyright satria//
class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataModel> = DataDummy.generateDataMovieDummy() as ArrayList<DataModel>
    private fun getListTvShow(): ArrayList<DataModel> = DataDummy.generateDataTvShowDummy() as ArrayList<DataModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataModel {
        lateinit var result: DataModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DataModel {
        lateinit var result: DataModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}

//copyright satria//