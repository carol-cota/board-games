package carolinacota.boardgames

import carolinacota.boardgames.application.ImportBoardGameUseCase
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
        val importBoardGameUseCase = applicationContext.getBean(ImportBoardGameUseCase::class.java)
        importBoardGameUseCase.import()
    }
}

fun main(args: Array<String>) {
    runApplication<BoardGamesApplication>(*args)
}