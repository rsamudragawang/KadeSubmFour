package com.ganargatul.kadesubmfour.connection

import com.ganargatul.kadesubmfour.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiServices {
    @GET("lookupleague.php")
    fun getDetailLeague(@Query("id") id: String  ): Call<LeagueResponse>

    @GET("eventsnextleague.php")
    fun getNextEvent(@Query("id") id:String ) : Call<NextEventResponse>

    @GET("lookupteam.php")
    fun getDetailTeam(@Query("id") id:String ) : Call<DetailTeamsResponse>
    @GET("searchevents.php")
    fun searchEvents(@Query("e") e:String ) : Call<SearchEventResponse>
//    eventspastleague
    @GET("eventspastleague.php")
    fun getPastEvent(@Query("id") e:String ) : Call<PastEventReponse>

    @GET("lookupevent.php")
    fun getDetailEvent(@Query("id") id: String) : Call<PastEventReponse>
}