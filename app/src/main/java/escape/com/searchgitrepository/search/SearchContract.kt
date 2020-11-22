package escape.com.searchgitrepository.search

interface SearchContract {

    interface View {

        val presenter: Presenter

        var isEndOfList: Boolean

        fun showProgress()
        fun hideProgress()

        fun setRepositoryTotalCount(count: String)
    }

    interface Presenter {

        fun start()
        fun loadRepositories(keyword: String, page: Int)

    }

}