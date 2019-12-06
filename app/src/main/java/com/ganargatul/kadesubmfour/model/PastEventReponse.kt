package com.ganargatul.kadesubmfour.model

import com.ganargatul.kadesubmfour.model.PastEventItems
import com.google.gson.annotations.SerializedName

data class PastEventReponse (
    @SerializedName("events")
    val events: List<PastEventItems>?
)