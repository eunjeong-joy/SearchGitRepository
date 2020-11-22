package escape.com.searchgitrepository.util

import java.text.DecimalFormat

fun setCommaFormat(number: Int): String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(number)
}
