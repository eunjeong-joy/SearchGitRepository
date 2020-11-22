package escape.com.searchgitrepository.data

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("items")
    val repositories: List<Repository>
)

data class Repository (
    @SerializedName("full_name")
    val fullName: String = "",
    @SerializedName("html_url")
    val htmlUrl: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("stargazers_count")
    val stargazersCount: Long = 0,
    @SerializedName("pushed_at")
    val pushedAt: String = "",
    @SerializedName("language")
    val language: String = ""
)