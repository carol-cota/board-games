package carolinacota.boardgames

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.boot.test.context.SpringBootTest

//@SpringBootTest
class BoardGamesApplicationTests {

    @Test
    fun contextLoads() {
        assertDoesNotThrow { main(emptyArray()) }
    }
}
