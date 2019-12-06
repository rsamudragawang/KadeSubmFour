package com.ganargatul.kadesubmfour.model

import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.google.gson.annotations.SerializedName
import retrofit2.Call

data class NextEventResponse (
    @SerializedName("events")
    val events: List<NextEventsItems>?
)