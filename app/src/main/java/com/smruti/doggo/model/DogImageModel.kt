package com.smruti.doggo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class DogImageModel(val id: String, val url: String,val name: String
,val type: String,val orign: String,val lifespan :String)