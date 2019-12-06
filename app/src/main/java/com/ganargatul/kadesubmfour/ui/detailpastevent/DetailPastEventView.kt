package com.ganargatul.kadesubmfour.ui.detailpastevent

import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.PastEventReponse
import com.ganargatul.kadesubmfour.test.repository.detailpastevent.DetailPastEventRepositoryCallback

interface DetailPastEventView  : DetailPastEventRepositoryCallback<PastEventReponse>{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<PastEventItems>)
}