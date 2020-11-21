package escape.com.searchgitrepository.data.source

class ResultRepository(remoteData: ResultDataSource) : ResultDataSource{

    private val remoteData = ResultRemoteDataSource()

    override fun getRepository(keyword: String, perPage: Int, page: Int) = remoteData.getRepository(keyword, perPage, page)

    companion object {
        private var INSTANCE: ResultRepository? = null

        @JvmStatic
        fun getInstance(remoteData: ResultRemoteDataSource): ResultRepository {
            return INSTANCE ?: ResultRepository(remoteData).apply {
                INSTANCE = this
            }
        }
    }
}