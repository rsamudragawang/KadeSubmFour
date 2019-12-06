package com.ganargatul.kadesubmfour.ui.detailnextevent

import com.ganargatul.kadesubmfour.model.*
import com.ganargatul.kadesubmfour.test.repository.detailnextevent.DetailNextEventRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepositoryCallback

interface DetailNextEventView  : DetailNextEventRepositoryCallback<DetailTeamsResponse> {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<DetailTeamsItems>)
}