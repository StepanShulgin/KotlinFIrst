package dataBank

data class Search (
    val ns: Int,
    val title: String,
    val pageid: Int,
    val size: Int,
    val wordcount: Int,
    val snippet: String,
    val timestamp: String
)