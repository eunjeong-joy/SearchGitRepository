package escape.com.searchgitrepository.network

import escape.com.searchgitrepository.data.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterfaceService {

    @Headers("Authorization: 59d75bb4281d1e78a660d537c72be49ce6e6e56b")
    @GET("/search/repositories")
    fun requestSearchRepository(): Call<SearchResponse>

}