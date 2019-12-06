package com.ganargatul.kadesubmfour.ui.nextevent

import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback

interface NextEventView  : NextEventRepositoryCallback<NextEventResponse>{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<NextEventsItems>)
}