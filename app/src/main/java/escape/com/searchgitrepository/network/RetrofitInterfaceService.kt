package escape.com.searchgitrepository.network

import escape.com.searchgitrepository.data.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitInterfaceService {

    @GET("/search/repositories")
    fun requestSearchRepository(
        @Header("Authorization") token:String,
        @Query("q") keyword: String,
        @Query("per_page") perPage: Int? = 20,
        @Query("page") page: Int? = 1
    ): Call<SearchResponse>

}