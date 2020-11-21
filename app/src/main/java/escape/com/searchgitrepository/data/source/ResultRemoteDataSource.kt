package escape.com.searchgitrepository.data.source

import escape.com.searchgitrepository.network.RepositoryInterfaceService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultRemoteDataSource: ResultDataSource {
    companion object {
        const val GITHUB_URL = "https://api.github.com"
    }

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val repositoryInterfaceService = retrofit.create(RepositoryInterfaceService::class.java)

    override fun getRepository(keyword: String, perPage: Int, page: Int) = repositoryInterfaceService.requestSearchRepository(keyword, perPage, page)

}