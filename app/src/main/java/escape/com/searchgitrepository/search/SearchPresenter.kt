package escape.com.searchgitrepository.search

import android.util.Log
import escape.com.searchgitrepository.data.RepositoryResponse
import escape.com.searchgitrepository.data.source.ResultRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter(
    private val view: SearchContract.View,
    private val repository: ResultRepository
) : SearchContract.Presenter {

    override fun start() {}

    override fun loadRepositories(keyword: String) {
        view.showProgress()

        repository.getRepository(keyword = keyword,page = 1,perPage = 20).enqueue(object : Callback<RepositoryResponse> {
            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<RepositoryResponse>,
                response: Response<RepositoryResponse>
            ) {
                view.hideProgress()
                if(response?.isSuccessful) {
                }
            }
        })
    }
}