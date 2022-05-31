package carolinacota.boardgames

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardGamesApplicationTests {

    @Test
    fun contextLoads() {
        assertDoesNotThrow { main(emptyArray()) } //=> This asserts the same thing that
        // @SpringBootTest asserts, since it is only trying to run/build the project
        // and make sure it does not throw any error
    }
}
