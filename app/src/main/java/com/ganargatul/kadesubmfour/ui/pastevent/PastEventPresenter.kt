package com.ganargatul.kadesubmfour.ui.pastevent

import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.PastEventReponse
import com.ganargatul.kadesubmfour.test.repository.pastevent.PastEventRepository
import com.ganargatul.kadesubmfour.test.repository.pastevent.PastEventRepositoryCallback

class PastEventPresenter(private val view: PastEventView,private val pastEventRepository: PastEventRepository) {
    fun loaddata(idEvent: String){
        view.showLoading()
        pastEventRepository.getNextMatch(idEvent,object :PastEventRepositoryCallback<PastEventReponse?>{
            override fun onDataError() {
               view.hideLoading()
            }

            override fun onDataLoaded(data: List<PastEventItems>) {
                view.hideLoading()
                view.showTeamList(data)
            }

        })
    }
}