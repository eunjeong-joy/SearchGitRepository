package escape.com.searchgitrepository.data.source

import escape.com.searchgitrepository.network.RepositoryInterfaceService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultRemoteDataSource: ResultDataSource {
    companion object {
        const val GITHUB_URL = "https://api.github.com"
        const val ACCESS_TOKEN = "91368a559cba303eb2ae16bdd40bdcdd3580a030"
    }

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val repositoryInterfaceService = retrofit.create(RepositoryInterfaceService::class.java)

    override fun getRepository(keyword: String, perPage: Int, page: Int) = repositoryInterfaceService.requestSearchRepository(ACCESS_TOKEN, keyword, perPage, page)

}