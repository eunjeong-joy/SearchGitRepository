package escape.com.searchgitrepository.search

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import escape.com.searchgitrepository.R
import escape.com.searchgitrepository.data.source.ResultRemoteDataSource
import escape.com.searchgitrepository.data.source.ResultRepository
import escape.com.searchgitrepository.search.adapter.ItemRecyclerAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchContract.View {

    override val presenter: SearchContract.Presenter by lazy {
        SearchPresenter(this, ResultRepository.getInstance(ResultRemoteDataSource()), itemRecyclerAdapter)
    }

    private val itemRecyclerAdapter: ItemRecyclerAdapter by lazy{
        ItemRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        list_item.run {
            adapter = itemRecyclerAdapter
            layoutManager = LinearLayoutManager(this.context)
        }

        input_search.setOnEditorActionListener{ textview, action, event ->
            var handled = false
            var text = input_search.text.toString()

            if(text.isEmpty()) {
                input_search.error = "Empty!"
            }

            if( action == EditorInfo.IME_ACTION_SEARCH) {
                presenter.loadRepositories(text)
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

    override fun setRepositoryTotalCount(count: Int) {
        tv_repository_count.text = count.toString()
    }
}