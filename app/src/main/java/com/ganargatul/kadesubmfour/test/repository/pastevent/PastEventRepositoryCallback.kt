package com.ganargatul.kadesubmfour.test.repository.pastevent

import com.ganargatul.kadesubmfour.model.PastEventItems

interface PastEventRepositoryCallback <T> {
    fun onDataLoaded(data: List<PastEventItems>)
    fun onDataError()
}