package com.ganargatul.kadesubmfour.test.repository.detailpastevent

import com.ganargatul.kadesubmfour.model.PastEventItems

interface DetailPastEventRepositoryCallback<T> {
    fun onDataLoaded(data: List<PastEventItems>)
    fun onDataError()
}