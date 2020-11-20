package escape.com.searchgitrepository.data

data class SearchResponse(
    val totalCount: Int = 0,
    val repositories: List<Repository>
)

data class Repository (
    val name: String = "",
    val fullName: String = "",
    val htmlUrl: String = "",
    val description: String = "",
    val stargazersCount: Int = 0,
    val pushedAt: Long = 0,
    val language: String = ""
)