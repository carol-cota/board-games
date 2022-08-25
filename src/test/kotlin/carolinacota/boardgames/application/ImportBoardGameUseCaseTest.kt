package carolinacota.boardgames.application

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameParser
import carolinacota.boardgames.domain.Repository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class ImportBoardGameUseCaseTest{
    private val boardGameRepository = mock<Repository<BoardGame>>()
    private val boardGameParser = mock<BoardGameParser>()
    private val importBoardGameUseCase = ImportBoardGameUseCase(boardGameRepository, boardGameParser)

    @Test
    fun `should call the parser`() {
//        when
        importBoardGameUseCase.import()
//        then
        verify(boardGameParser).call()
    }

    @Test
    fun `should persist the parser result`() {
//        given
//        parser result
//        when
        importBoardGameUseCase.import()
//        then
        verify(boardGameParser).call()
        verify(boardGameRepository).save()
    }
}