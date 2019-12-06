package com.ganargatul.kadesubmfour.test.repository.nextevent

import com.ganargatul.kadesubmfour.connection.RetroConfig
import com.ganargatul.kadesubmfour.model.NextEventResponse
import retrofit2.Call
import retrofit2.Response

class NextEventRepository {
    fun getNextMatch(id: String, callback: NextEventRepositoryCallback<NextEventResponse?>) {
        RetroConfig().services.getNextEvent(id).enqueue(object: retrofit2.Callback<NextEventResponse> {
            override fun onFailure(call: Call<NextEventResponse>, t: Throwable) {
//                Log.d("onFailure", t.message)
            }

            override fun onResponse(
                call: Call<NextEventResponse>,
                response: Response<NextEventResponse>
            ) {
//                    Log.d("presenter", response.code().toString())

                response.let {
                    if (it.isSuccessful) {
                        it.body().let {
                            it?.events?.let { it1 -> callback.onDataLoaded(it1) }
                        }
                    } else {
                        callback.onDataError()
                    }
                }
            }
        })
    }
}