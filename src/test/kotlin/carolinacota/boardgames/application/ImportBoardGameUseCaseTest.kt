package carolinacota.boardgames.application

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameParser
import carolinacota.boardgames.domain.Repository
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class ImportBoardGameUseCaseTest {
    private val boardGameRepository = mock<Repository<BoardGame>>()
    private val boardGameParser = mock<BoardGameParser>()
    private val importBoardGameUseCase = ImportBoardGameUseCase(boardGameRepository, boardGameParser)

    @Test
    fun `should call the repository with parser result`() {
        val parserResult = listOf<BoardGame>(BoardGame("hello", "Hello", 2, 4.8))
        given(boardGameParser.call()).willReturn(parserResult)

        importBoardGameUseCase.import()

        verify(boardGameRepository).save(parserResult)
    }

    @Test
    fun `should forward boardGameParser exception`() {
        given(boardGameParser.call()).willThrow(RuntimeException("Error"))

        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy { importBoardGameUseCase.import() }
    }

    @Test
    fun `should forward boardGameRepository exception`() {
        given(boardGameRepository.save(any())).willThrow(RuntimeException("Error"))

        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy { importBoardGameUseCase.import() }
    }
}