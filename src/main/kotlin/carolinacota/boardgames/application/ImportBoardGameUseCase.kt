package carolinacota.boardgames.application

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameParser
import carolinacota.boardgames.domain.Repository
import carolinacota.boardgames.repository.BoardGameRepository

class ImportBoardGameUseCase(
    private val boardGameRepository: Repository<BoardGame>,
    private val boardGameParser: BoardGameParser
) {

    fun import() {
        val list = boardGameParser.call()
        boardGameRepository.save(list)
    }
}
