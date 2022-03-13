package com.example.beersappmvparchitecture.presentation.beer.model

data class BeerView(
    var id: Long?,
    var name: String?,
    var tagline: String?,
    var firstBrewed: String?,
    var description: String?,
    var imageUrl: String?,
    var attenuation_level: Double?,
)