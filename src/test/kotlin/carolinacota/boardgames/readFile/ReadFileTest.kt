package carolinacota.boardgames.readFile

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource
import org.springframework.util.ResourceUtils

internal class ReadFileTest {
    private val file = ClassPathResource("board-games.xlsx").file.toPath().toAbsolutePath().toString()
    private val readFile = ReadFile(file)

    @Test
    fun `should return 7 elements`(){
        val result = readFile.call()
        assertEquals(7, result.size)
    }

    @Test
    fun `elements should have correct ids`(){
        val ids = listOf("174430", "161936", "224517", "167791", "233078", "291457", "182028")
        val result = readFile.call().map { it.id }
        assertEquals(ids, result)
    }

    @Test
    fun `elements should have correct names`(){
        val names = listOf("Gloomhaven", "Pandemic Legacy: Season 1", "Brass: Birmingham", "Terraforming Mars", "Twilight Imperium: Fourth Edition", "Gloomhaven: Jaws of the Lion", "Through the Ages: A New Story of Civilization"
        )
        val result = readFile.call().map { it.name }
        assertEquals(names, result)
    }

}