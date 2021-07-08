package com.example.truffol_kmm.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TruffleApiModel(
    @SerialName("id") val id: Int,
    @SerialName("title") val tartufoName: String,
    @SerialName("description") val description: String,
    @SerialName("image_url") val image_url: String,
    @SerialName("rating") val rating: Long,
    @SerialName("price") val price: Long
    // TODO: 08.07.21 : Add these fields to the API
    //val dateAdded: LocalDateTime,
    //val dateUpdated: LocalDateTime,
)

// TODO: 08.07.21 : Adjust Api so to use an ApiModel List (Currently not used)
@Serializable
data class TruffleListApiModel(
    @SerialName("count") var count: Int, // TODO: 08.07.21 : Add me 
    @SerialName("tartufi") val truffleList: List<TruffleApiModel>
)