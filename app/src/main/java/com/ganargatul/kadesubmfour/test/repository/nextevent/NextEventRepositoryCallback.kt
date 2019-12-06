package com.ganargatul.kadesubmfour.test.repository.nextevent

import com.ganargatul.kadesubmfour.model.NextEventsItems

interface NextEventRepositoryCallback<T> {
    fun onDataLoaded(data: List<NextEventsItems>)
    fun onDataError()
}