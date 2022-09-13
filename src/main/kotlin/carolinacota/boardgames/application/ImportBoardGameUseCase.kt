package carolinacota.boardgames.application

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameParser
import carolinacota.boardgames.domain.BoardGameRepository

class ImportBoardGameUseCase(
    private val boardGameRepository: BoardGameRepository,
    private val boardGameParser: BoardGameParser
) {

    fun import() {
        val list = boardGameParser.call()
        boardGameRepository.save(list)
    }
}
