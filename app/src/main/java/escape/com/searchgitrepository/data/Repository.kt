package escape.com.searchgitrepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Repository")
data class Repository @JvmOverloads constructor(
    @ColumnInfo(name = "name") var name:String = "",
    @ColumnInfo(name = "html_url") var htmlUrl:String = "",
    @ColumnInfo(name = "owner") var owner: Owner? = null
)