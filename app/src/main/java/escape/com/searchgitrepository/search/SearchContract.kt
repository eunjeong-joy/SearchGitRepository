package escape.com.searchgitrepository.search

interface SearchContract {

    interface View {

        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {

        fun loadRepositories()

    }

}