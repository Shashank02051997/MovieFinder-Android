package com.shashank.platform.moviefinder

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("?type=movie")
    fun getSearchResultData(
        @Query(value = "s") searchTitle: String, @Query(value = "apiKey") apiKey: String, @Query(
            value = "page"
        ) pageIndex: Int
    ): Call<SearchResults>

    @GET("?plot=full")
    fun getMovieDetailData(@Query(value = "t") title: String, @Query(value = "apiKey") apiKey: String): Call<MovieDetail>

}