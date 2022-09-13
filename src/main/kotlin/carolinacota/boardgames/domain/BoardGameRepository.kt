package carolinacota.boardgames.domain

interface BoardGameRepository {
    fun save(item: List<BoardGame>)
}