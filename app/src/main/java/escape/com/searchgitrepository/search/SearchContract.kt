package escape.com.searchgitrepository.search

interface SearchContract {

    interface View {

        var presenter: SearchContract.Presenter

        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {

        fun start()
        fun loadRepositories(keyword: String)

    }

}