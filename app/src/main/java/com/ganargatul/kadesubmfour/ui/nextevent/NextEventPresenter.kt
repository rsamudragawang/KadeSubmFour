package com.ganargatul.kadesubmfour.ui.nextevent

import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepository
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepositoryCallback

class NextEventPresenter(private val view: NextEventView,private val NextEventRepository: NextEventRepository) {
    fun loadData(idEvent: String){
//        Log.d("presenter", "presenter")

            view.showLoading()

            NextEventRepository.getNextMatch(idEvent,object : NextEventRepositoryCallback<NextEventResponse?>{
                override fun onDataLoaded(data: List<NextEventsItems>) {
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