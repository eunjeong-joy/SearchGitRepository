package escape.com.searchgitrepository.search

import escape.com.searchgitrepository.data.RepositoryResponse
import escape.com.searchgitrepository.data.source.ResultRepository
import escape.com.searchgitrepository.search.adapter.ItemRecyclerAdapter
import escape.com.searchgitrepository.util.setCommaFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter(
    private val view: SearchContract.View,
    private val repository: ResultRepository,
    private val itemRecyclerAdapter: ItemRecyclerAdapter
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
                if (response.isSuccessful) {
                    response.body()?.let {
                        var totalCount: Int = it.totalCount
                        view.setRepositoryTotalCount(setCommaFormat(totalCount))

                        var itemList = it.repositories
                        itemList.forEach {
                            itemRecyclerAdapter.addItem(it)
                        }
                        itemRecyclerAdapter.notifyDataSetChanged()
                    } ?: let {
                        //count 0
                    }
                }
                view.hideProgress()
            }
        })
    }
}