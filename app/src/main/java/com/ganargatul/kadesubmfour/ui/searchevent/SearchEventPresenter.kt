package com.ganargatul.kadesubmfour.ui.searchevent

import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.model.PastEventItems
import com.ganargatul.kadesubmfour.model.SearchEventResponse
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepository
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback
import com.ganargatul.kadesubmfour.test.repository.searchevent.SearchEventRepository
import com.ganargatul.kadesubmfour.test.repository.searchevent.SearchEventRepositoryCallback

class SearchEventPresenter(private val view: SearchEventView, private val NextEventRepository: SearchEventRepository) {
    fun loadData(idEvent: String){
//        Log.d("presenter", "presenter")

            view.showLoading()

            NextEventRepository.getNextMatch(idEvent,object : SearchEventRepositoryCallback<SearchEventResponse?>{
                override fun onDataLoaded(data: List<PastEventItems>) {
                    view.hideLoading()
                    view.showTeamList(data)
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