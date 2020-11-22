package escape.com.searchgitrepository.search

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import escape.com.searchgitrepository.R
import escape.com.searchgitrepository.data.source.ResultRemoteDataSource
import escape.com.searchgitrepository.data.source.ResultRepository
import escape.com.searchgitrepository.search.adapter.ItemRecyclerAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchContract.View {

    private var mKeyword: String = ""
    private var mPage: Int = 1

    override val presenter: SearchContract.Presenter by lazy {
        SearchPresenter(this, ResultRepository.getInstance(ResultRemoteDataSource()), itemRecyclerAdapter)
    }

    override var isEndOfList: Boolean = false

    private val itemRecyclerAdapter: ItemRecyclerAdapter by lazy{
        ItemRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        list_recyclerview.run {
            adapter = itemRecyclerAdapter
            layoutManager = LinearLayoutManager(this.context)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if(!canScrollVertically(1) && !isEndOfList){
                        mPage++
                        presenter.loadRepositories(mKeyword, mPage)
                    }
                }
            })
        }


        input_search.setOnEditorActionListener{ textview, action, event ->
            var handled = false
            mKeyword = input_search.text.toString()

            if(mKeyword.isEmpty()) {
                input_search.error = "Empty!"
            }

            if(action == EditorInfo.IME_ACTION_SEARCH) {
                isEndOfList = false
                itemRecyclerAdapter.clear()
                var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(input_search.windowToken, 0)
                presenter.loadRepositories(mKeyword, mPage)
            }

            handled
        }
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun setRepositoryTotalCount(count: String) {
        tv_repository_count.text = count + " " + getString(R.string.total_count_title)
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this@SearchActivity, message, Toast.LENGTH_SHORT).show()
    }

}