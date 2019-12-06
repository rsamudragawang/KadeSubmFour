package com.ganargatul.kadesubmfour.ui.searchevent

import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.SearchEventResponse
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.searchevent.SearchEventRepositoryCallback

interface SearchEventView  : SearchEventRepositoryCallback<SearchEventResponse>{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<PastEventItems>)
}