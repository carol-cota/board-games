package carolinacota.boardgames.repository

import carolinacota.boardgames.domain.BoardGame
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

internal class MemoryBoardGameRepositoryTest {
    private val boardGameRepository = MemoryBoardGameRepository()

    @Test
    fun `should add boardGame received to the memory`() {
        val list = listOf(BoardGame("123", "MyGame", 10, 4.5))

        boardGameRepository.save(list)

        assertIterableEquals(MemoryBoardGameRepository.Companion.boardGameList, list)
    }
}