package carolinacota.boardgames.repository

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameRepository
import org.springframework.stereotype.Repository

@Repository
class MemoryBoardGameRepository() : BoardGameRepository {

    override fun save(boardGames: List<BoardGame>) {
        boardGameList.addAll(boardGames)
    }

    companion object {
        val boardGameList = mutableListOf<BoardGame>()
    }
}
