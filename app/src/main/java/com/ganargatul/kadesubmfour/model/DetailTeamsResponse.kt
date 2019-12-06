package com.ganargatul.kadesubmfour.model

import com.ganargatul.kadesubmfour.model.DetailTeamsItems
import com.google.gson.annotations.SerializedName

data class DetailTeamsResponse (
    @SerializedName("teams")
    val events: List<DetailTeamsItems>?
)