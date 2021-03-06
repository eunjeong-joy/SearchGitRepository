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

    companion object {
        const val PER_PAGE = 20
    }

    init {
        itemRecyclerAdapter.onClick = { position ->
            var url = itemRecyclerAdapter.getItem(position).htmlUrl
            view.goRepositoryWeb(url)
        }
    }

    override fun loadRepositories(keyword: String, page: Int) {
        view.showProgress()

        repository.getRepository(keyword = keyword,page = page,perPage = PER_PAGE).enqueue(object : Callback<RepositoryResponse> {
            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                showToastErrorMessage(t.message.toString())
            }

            override fun onResponse(
                call: Call<RepositoryResponse>,
                response: Response<RepositoryResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { it ->
                        setTotalCount(it.totalCount)

                        var itemList = it.repositories
                        itemList.forEach {
                            itemRecyclerAdapter.addItem(it)
                        }
                        if(itemList.size < PER_PAGE) view.isEndOfList = true

                        itemRecyclerAdapter.notifyDataSetChanged()
                    } ?: setTotalCount(0)
                } else {
                    showToastErrorMessage(response.message())
                }
                view.hideProgress()
            }
        })
    }

    private fun setTotalCount(totalCount: Int) {
        view.setRepositoryTotalCount(setCommaFormat(totalCount))
    }

    private fun showToastErrorMessage(message: String) {
        view.showErrorMessage(message)
    }
}