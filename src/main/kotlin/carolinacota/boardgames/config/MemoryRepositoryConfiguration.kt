package carolinacota.boardgames.config

import carolinacota.boardgames.domain.BoardGame
import org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class MemoryRepositoryConfiguration {

    @Bean
    @Scope(SCOPE_SINGLETON)
    fun boardGameList() = mutableListOf<BoardGame>()
}