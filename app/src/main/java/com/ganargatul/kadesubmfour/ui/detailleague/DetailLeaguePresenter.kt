package com.ganargatul.kadesubmfour.ui.detailleague

import com.ganargatul.kadesubmfour.model.LeagueDetailsItem
import com.ganargatul.kadesubmfour.model.LeagueResponse
import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.test.repository.detailleague.DetailLeagueRepository
import com.ganargatul.kadesubmfour.test.repository.detailleague.DetailLeagueRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepository
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback

class DetailLeaguePresenter(private val view: DetailLeagueView, private val detailLeagueRepository: DetailLeagueRepository) {
    fun loadData(idEvent: String){
//        Log.d("presenter", "presenter")

            view.showLoading()
        detailLeagueRepository.getNextMatch(idEvent,object : DetailLeagueRepositoryCallback<LeagueResponse?>{
            override fun onDataLoaded(data: List<LeagueDetailsItem>?) {
                view.hideLoading()
                data?.let { view.showTeamList(it) }
            }

            override fun onDataError() {
                view.hideLoading()
            }

        })
//            RetroConfig().services.getNextEvent(idEvent).enqueue(object: retrofit2.Callback<NextEventResponse>{
//                override fun onFailure(call: Call<NextEventResponse>, t: Throwable) {
//                    Log.d("onFailure", t.message)
//                }
//
//                override fun onResponse(
//                    call: Call<NextEventResponse>,
//                    response: Response<NextEventResponse>
//                ) {
////                    Log.d("presenter", response.code().toString())
//
//                    if (response.code() == 200){
//                        view.hideLoading()
//                        response.body()?.events.let {
//                            it?.let { it1 -> view.showTeamList(it1) }
//                        }
//                    }
//                }
//
//            })



    }
}