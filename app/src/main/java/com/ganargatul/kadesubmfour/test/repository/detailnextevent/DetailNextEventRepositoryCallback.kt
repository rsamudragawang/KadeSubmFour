package com.ganargatul.kadesubmfour.test.repository.detailnextevent


import com.ganargatul.kadesubmfour.model.DetailTeamsItems

interface DetailNextEventRepositoryCallback<T> {
    fun onDataLoaded(data: List<DetailTeamsItems>)
    fun onDataError()
}