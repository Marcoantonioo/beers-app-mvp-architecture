package com.example.beersappmvparchitecture.data.remote.entity

import com.example.beersappmvparchitecture.domain.model.BeerDomain

data class BeerRemote(
    var id: Long?,
    var name: String?,
    var tagline: String?,
    var firstBrewed: String?,
    var description: String?,
    var imageUrl: String?,
    var attenuation_level: Double?
) {
    fun toModel() = BeerDomain(
        id = this.id,
        name = this.name,
        tagline = this.tagline,
        firstBrewed = this.firstBrewed,
        description = this.description,
        imageUrl = this.imageUrl,
        attenuation_level = this.attenuation_level,
    )
}