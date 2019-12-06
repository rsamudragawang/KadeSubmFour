package com.ganargatul.kadesubmfour.ui.detailnextevent

import android.util.Log.d
import com.ganargatul.kadesubmfour.model.DetailTeamsItems
import com.ganargatul.kadesubmfour.model.DetailTeamsResponse
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepository
import com.ganargatul.kadesubmfour.test.repository.getAwayBadge.GetAwayBadgeRepositoryCallback

class GetAwayBadgePresenter(private val view: GetAwayBadgeView, private val pastEventRepository: GetAwayBadgeRepository) {

    fun loaddata(id: String){
//        d("presenter","presenter")
        pastEventRepository.getNextMatch(id,object :
            GetAwayBadgeRepositoryCallback<DetailTeamsResponse?> {
            override fun onBadgeAway(data: List<DetailTeamsItems>) {
                view.show(data)
            }

        })
    }
}