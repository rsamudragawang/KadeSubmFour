package com.ganargatul.kadesubmfour.model

import com.google.gson.annotations.SerializedName

data class LeagueDetailsItem(
    @SerializedName("strDescriptionEN")
    val strDescriptionEN:String?,
    @SerializedName("strWebsite")
    val strWebsite:String?
)