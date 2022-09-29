package carolinacota.boardgames.adapters

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameRepository
import org.springframework.stereotype.Repository

@Repository
class MemoryBoardGameRepository(
    private val boardGamesList: MutableList<BoardGame>
) : BoardGameRepository {

    override fun save(boardGames: List<BoardGame>) {
        boardGamesList.addAll(boardGames)
    }
}
