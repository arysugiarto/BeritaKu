package id.arysugiarto.beritaku.api

import id.arysugiarto.beritaku.model.TopHeadlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface TopHeadlinesEndpoint {
    @GET("top-headlines")
    fun getTopHeadLines(
        @Query("country") country : String,
        @Query("apiKey") apiKey: String
    ): Observable <TopHeadlines>

    @GET("top-headlines")
    fun getuserSearchInput(
        @Query("apiKey") apiKey: String,
        @Query("q") q : String
    ): Observable<TopHeadlines>
}