package carolinacota.boardgames.domain

interface BoardGameParser {
    fun call() : List<BoardGame>
}