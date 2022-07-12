package carolinacota.boardgames

import carolinacota.boardgames.readFile.ReadFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class BoardGamesApplication : CommandLineRunner {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    override fun run(vararg args: String?) {
        val readFile = applicationContext.getBean(ReadFile::class.java)
        print(readFile.call())
    }

}

fun main(args: Array<String>) {
    runApplication<BoardGamesApplication>(*args)
}