package com.ganargatul.kadesubmfour.ui.searchevent

import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.SearchEventResponse
import com.ganargatul.kadesubmfour.test.repository.searchevent.SearchEventRepository
import com.ganargatul.kadesubmfour.test.repository.searchevent.SearchEventRepositoryCallback
import com.ganargatul.kadesubmfour.ui.nextevent.NextEventPresenter
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchEventPresenterTest {
    @Mock
    private lateinit var view: SearchEventView

    @Mock
    private lateinit var searchEventRepository: SearchEventRepository

    private lateinit var presenter: SearchEventPresenter


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchEventPresenter(view,searchEventRepository)
    }
    @Test
    fun loadData() {
        var teams: List<PastEventItems> = mutableListOf()
        val league = "Barcelona vs real"
        presenter.loadData(league)
        argumentCaptor<SearchEventRepositoryCallback<SearchEventResponse?>>().apply {

            verify(searchEventRepository).getNextMatch(eq(league), capture())
            firstValue.onDataLoaded(teams)
        }
        Mockito.verify(view).showLoading()
        Mockito.verify(view).showTeamList(teams)
        Mockito.verify(view).hideLoading()
    }
}