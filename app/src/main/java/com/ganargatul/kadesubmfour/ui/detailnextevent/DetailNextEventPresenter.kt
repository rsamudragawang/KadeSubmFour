package com.ganargatul.kadesubmfour.ui.detailnextevent

import android.util.Log.d
import com.ganargatul.kadesubmfour.model.DetailTeamsItems
import com.ganargatul.kadesubmfour.model.DetailTeamsResponse
import com.ganargatul.kadesubmfour.test.repository.detailnextevent.DetailNextEventRepository
import com.ganargatul.kadesubmfour.test.repository.detailnextevent.DetailNextEventRepositoryCallback

class DetailNextEventPresenter(private val view: DetailNextEventView, private val pastEventRepository: DetailNextEventRepository) {

    fun loaddata(id: String){
        view.showLoading()
//        d("presenter","presenter")
        pastEventRepository.getNextMatch(id,object :
            DetailNextEventRepositoryCallback<DetailTeamsResponse?> {
            override fun onDataLoaded(data: List<DetailTeamsItems>) {
                view.hideLoading()
                view.showTeamList(data)
            }

            override fun onDataError() {
                view.hideLoading()
            }
        })
    }
}