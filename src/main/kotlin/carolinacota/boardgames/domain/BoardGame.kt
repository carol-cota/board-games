package carolinacota.boardgames.domain

data class BoardGame(
    val id: String,
    val name: String,
    val numberOfRatings: Int? = null,
    val ratingAverage: Double? = null
)
