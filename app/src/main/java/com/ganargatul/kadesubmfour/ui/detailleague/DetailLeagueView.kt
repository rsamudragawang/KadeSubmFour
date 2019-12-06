package com.ganargatul.kadesubmfour.ui.detailleague

import com.ganargatul.kadesubmfour.model.LeagueDetailsItem
import com.ganargatul.kadesubmfour.model.LeagueResponse
import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.test.repository.detailleague.DetailLeagueRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback

interface DetailLeagueView  : DetailLeagueRepositoryCallback<LeagueResponse>{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<LeagueDetailsItem>)
}