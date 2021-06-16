package com.smruti.doggo.repository.remote

import com.smruti.doggo.model.DogImageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DoggoApiService {

    @GET("v1/images/search")
    suspend fun getDoggoImages(@Query("page") page: Int, @Query("limit") size: Int): List<DogImageModel>

}