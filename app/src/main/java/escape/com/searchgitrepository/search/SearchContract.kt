package escape.com.searchgitrepository.search

interface SearchContract {

    interface View {

        val presenter: Presenter
        var isEndOfList: Boolean

        fun showProgress()
        fun hideProgress()

        fun setRepositoryTotalCount(count: String)
        fun showErrorMessage(message: String)

        fun goRepositoryWeb(url: String)
    }

    interface Presenter {

        fun loadRepositories(keyword: String, page: Int)

    }

}