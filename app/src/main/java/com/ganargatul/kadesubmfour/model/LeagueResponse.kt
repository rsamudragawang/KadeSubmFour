package com.ganargatul.kadesubmfour.model

import com.ganargatul.kadesubmfour.model.LeagueDetailsItem
import com.google.gson.annotations.SerializedName

data class LeagueResponse (
    @SerializedName("leagues")
    val leagues: List<LeagueDetailsItem>?
)