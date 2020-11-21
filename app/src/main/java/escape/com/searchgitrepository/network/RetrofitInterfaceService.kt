package escape.com.searchgitrepository.network

import escape.com.searchgitrepository.data.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterfaceService {

    @GET("/search/repositories")
    fun requestSearchRepository(): Call<SearchResponse>

}