package com.example.beersappmvparchitecture.domain.model

import com.example.beersappmvparchitecture.presentation.beer.model.BeerView
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BeerDomain(
    var id: Long?,
    var name: String?,
    var tagline: String?,
    var firstBrewed: String?,
    var description: String?,
    var imageUrl: String?,
    var attenuation_level: Double?,
) {
    fun toView() = BeerView(
        id = this.id,
        name = this.name,
        tagline = this.tagline,
        firstBrewed = this.firstBrewed,
        description = this.description,
        imageUrl = this.imageUrl,
        attenuation_level = this.attenuation_level,
    )
}