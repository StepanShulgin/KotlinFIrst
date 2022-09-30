package dataBank

data class ApiRequest (
    val batchcomplete: String,
    val cContinue: Continue,
    val query: Query
)