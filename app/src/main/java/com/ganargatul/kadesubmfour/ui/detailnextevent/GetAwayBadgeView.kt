package com.ganargatul.kadesubmfour.ui.detailnextevent

import com.ganargatul.kadesubmfour.model.*
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepositoryCallback

interface GetAwayBadgeView  : GetAwayBadgeRepositoryCallback<DetailTeamsResponse> {
    fun show(data: List<DetailTeamsItems>)
}