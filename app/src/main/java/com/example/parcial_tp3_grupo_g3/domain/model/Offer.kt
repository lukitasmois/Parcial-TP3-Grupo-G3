package com.example.parcial_tp3_grupo_g3.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Offer (
    val name:String,
    val discount:Int,
    val titletext:String,
    val bodytext:String,
    val cardImg:String
)
