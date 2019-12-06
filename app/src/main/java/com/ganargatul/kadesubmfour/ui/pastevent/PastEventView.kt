package com.ganargatul.kadesubmfour.ui.pastevent

import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.PastEventReponse
import com.ganargatul.kadesubmfour.test.repository.pastevent.PastEventRepositoryCallback

interface PastEventView : PastEventRepositoryCallback<PastEventReponse> {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<PastEventItems>)
}