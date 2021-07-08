package com.example.truffol_kmm.domain.model

data class Truffle(
    val id: Int,
    val truffleName: String,
    val description: String,
    val image_url: String,
    val rating: Long,
    val price: Long,
    // TODO: 08.07.21 : Add these fields to the API
    //val dateAdded: LocalDateTime,
    //val dateUpdated: LocalDateTime,
)