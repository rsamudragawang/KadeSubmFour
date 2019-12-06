package com.ganargatul.kadesubmfour.ui.detailnextevent

import com.ganargatul.kadesubmfour.model.DetailTeamsItems
import com.ganargatul.kadesubmfour.model.DetailTeamsResponse
import com.ganargatul.kadesubmfour.test.repository.detailnextevent.DetailNextEventRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepository
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepositoryCallback
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAwayBadgePresenterTest {
    @Mock
    private lateinit var view: GetAwayBadgeView

    @Mock
    private lateinit var getAwayBadgeRepository: GetAwayBadgeRepository

    private lateinit var presenter: GetAwayBadgePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = GetAwayBadgePresenter(view,getAwayBadgeRepository)
    }
    @Test
    fun loaddata() {
        var teams: List<DetailTeamsItems> = mutableListOf()
        val league = "602277"
        presenter.loaddata(league)
        argumentCaptor<GetAwayBadgeRepositoryCallback<DetailTeamsResponse?>>().apply {

            verify(getAwayBadgeRepository).getNextMatch(eq(league), capture())
            firstValue.onBadgeAway(teams)
        }
        Mockito.verify(view).show(teams)
    }
}