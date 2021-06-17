package com.satria.jpro.firstsubmission.ui.home

import androidx.lifecycle.ViewModel
import com.satria.jpro.firstsubmission.model.DataModel
import com.satria.jpro.firstsubmission.utils.DataDummy

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = DataDummy.generateDataMovieDummy()

    fun getListTvShow(): List<DataModel> = DataDummy.generateDataTvShowDummy()

}