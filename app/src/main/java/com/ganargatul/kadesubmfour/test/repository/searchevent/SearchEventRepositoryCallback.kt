package com.ganargatul.kadesubmfour.test.repository.searchevent

import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.model.PastEventItems

interface SearchEventRepositoryCallback<T> {
    fun onDataLoaded(data: List<PastEventItems>)
    fun onDataError()
}