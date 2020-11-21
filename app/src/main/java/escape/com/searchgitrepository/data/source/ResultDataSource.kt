package escape.com.searchgitrepository.data.source

import escape.com.searchgitrepository.data.RepositoryResponse
import retrofit2.Call

interface ResultDataSource {

    fun getRepository( keyword: String, perPage: Int, page: Int): Call<RepositoryResponse>
}