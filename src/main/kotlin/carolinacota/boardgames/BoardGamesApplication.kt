package carolinacota.boardgames

import carolinacota.boardgames.readFile.XLSXBoardGameParser
import carolinacota.boardgames.repository.MemoryBoardGameRepository
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
        val boardGameParser = applicationContext.getBean(XLSXBoardGameParser::class.java)
        val boardGames = boardGameParser.call()
        val repository = applicationContext.getBean(MemoryBoardGameRepository::class.java)
        repository.save(boardGames)
    }
}

fun main(args: Array<String>) {
    runApplication<BoardGamesApplication>(*args)
}