package carolinacota.boardgames.readFile

data class BoardGame(
    val id: String,
    val name: String,
    val yearPublished: String? = null,
    val minPlayers: Int? = null,
    val maxPlayers: Int? = null,
    val playTime: Int? = null,
    val minAge: Int? = null,
    val numberOfRatings: Int? = null,
    val ratingAverage: Double? = null,
    val bggRank: Int? = null,
    val complexityAverage: Double? = null,
    val ownedGames: Int? = null,
    val mechanics: String? = null,
    val domains: String? = null,
)
