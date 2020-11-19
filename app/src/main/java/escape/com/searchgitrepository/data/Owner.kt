package escape.com.searchgitrepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Owner")
data class Owner @JvmOverloads constructor(
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "avatar_url") var avatarUrl:String = ""
)