package com.ganargatul.kadesubmfour.test.repository.getAwayBadge


import com.ganargatul.kadesubmfour.model.DetailTeamsItems
import com.ganargatul.kadesubmfour.model.NextEventsItems

interface GetAwayBadgeRepositoryCallback<T> {
    fun onBadgeAway(data: List<DetailTeamsItems>)
}