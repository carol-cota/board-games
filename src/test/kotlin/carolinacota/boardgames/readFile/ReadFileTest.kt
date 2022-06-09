package carolinacota.boardgames.readFile

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource

internal class ReadFileTest {
    private val file = ClassPathResource("board-games-test.xlsx").file.toPath().toAbsolutePath().toString()
    private val readFile = ReadFile(file)

    @Test
    fun `should return 7 elements`() {
        val result = readFile.call()
        assertThat(7).isEqualTo(result.size)
    }

    @Test
    fun `elements should have correct ids`() {
        val ids = listOf("174430", "161936", "224517", "167791", "233078", "291457", "182028")
        val result = readFile.call().map { it.id }
        assertThat(ids).isEqualTo(result)
    }

    @Test
    fun `elements should have correct names`() {
        val names = listOf(
            "Gloomhaven",
            "Pandemic Legacy: Season 1",
            "Brass: Birmingham",
            "Terraforming Mars",
            "Twilight Imperium: Fourth Edition",
            "Gloomhaven: Jaws of the Lion",
            "Through the Ages: A New Story of Civilization"
        )
        val result = readFile.call().map { it.name }
        assertThat(names).isEqualTo(result)
    }

}