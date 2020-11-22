package escape.com.searchgitrepository.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import kotlin.math.ln
import kotlin.math.pow

fun setCommaFormat(number: Int): String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(number)
}

fun setShortNumberFormat(number: Long):String {
    if(number < 1000) return number.toString()

    val exp = (ln(number.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f%c", number / 1000.0.pow(exp.toDouble()), "KMGTPE" [exp - 1])
}

fun setUpdatedDateFormat(updateDate: String): String {
    val updateTimeStamp = SimpleDateFormat("yyyy-MM-dd").parse(updateDate).time
    return SimpleDateFormat("yyyy-MM-dd").format(updateTimeStamp).toString()
}