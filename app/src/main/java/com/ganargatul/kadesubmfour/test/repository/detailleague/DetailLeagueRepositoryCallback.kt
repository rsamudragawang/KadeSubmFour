package com.ganargatul.kadesubmfour.test.repository.detailleague


import com.ganargatul.kadesubmfour.model.LeagueDetailsItem

interface DetailLeagueRepositoryCallback<T> {
    fun onDataLoaded(data: List<LeagueDetailsItem>?)
    fun onDataError()
}