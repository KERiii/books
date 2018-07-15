package com.danielkeresztes.books.network

import com.danielkeresztes.books.vo.VolumeResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface BookService {

    @GET("volumes")
    fun search(@QueryMap queryMap: Map<String, String>): Single<VolumeResponse>
}