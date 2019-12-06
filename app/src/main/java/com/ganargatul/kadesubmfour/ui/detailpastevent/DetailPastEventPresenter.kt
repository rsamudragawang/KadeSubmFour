package com.ganargatul.kadesubmfour.ui.detailpastevent

import android.util.Log.d
import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.PastEventReponse
import com.ganargatul.kadesubmfour.test.repository.detailpastevent.DetailPastEventRepository
import com.ganargatul.kadesubmfour.test.repository.detailpastevent.DetailPastEventRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.pastevent.PastEventRepositoryCallback
import com.ganargatul.kadesubmfour.ui.pastevent.PastEventView

class DetailPastEventPresenter(private val view: DetailPastEventView,private val pastEventRepository: DetailPastEventRepository) {

    fun loaddata(id: String){
        view.showLoading()
//        d("presenter","presenter")
        pastEventRepository.getNextMatch(id,object : DetailPastEventRepositoryCallback<PastEventReponse?>{
            override fun onDataLoaded(data: List<PastEventItems>) {
                view.hideLoading()
                view.showTeamList(data)
            }

            override fun onDataError() {
                view.hideLoading()
            }
        })
    }
}