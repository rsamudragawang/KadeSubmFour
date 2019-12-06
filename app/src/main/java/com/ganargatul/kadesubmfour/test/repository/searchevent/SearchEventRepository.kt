package com.ganargatul.kadesubmfour.test.repository.searchevent

import com.ganargatul.kadesubmfour.connection.RetroConfig
import com.ganargatul.kadesubmfour.model.NextEventResponse
import com.ganargatul.kadesubmfour.model.SearchEventResponse
import retrofit2.Call
import retrofit2.Response

class SearchEventRepository {
    fun getNextMatch(id: String, callback: SearchEventRepositoryCallback<SearchEventResponse?>) {
        RetroConfig().services.searchEvents(id).enqueue(object: retrofit2.Callback<SearchEventResponse> {
            override fun onFailure(call: Call<SearchEventResponse>, t: Throwable) {
//                Log.d("onFailure", t.message)
            }

            override fun onResponse(
                call: Call<SearchEventResponse>,
                response: Response<SearchEventResponse>
            ) {
//                    Log.d("presenter", response.code().toString())

                response.let {
                    if (it.isSuccessful) {
                        it.body().let {
                            it?.event?.let { it1 -> callback.onDataLoaded(it1) }
                        }
                    } else {
                        callback.onDataError()
                    }
                }
            }
        })
    }
}