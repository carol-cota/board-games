package carolinacota.boardgames.repository

import carolinacota.boardgames.domain.BoardGame
import org.springframework.stereotype.Repository

@Repository
class BoardGameRepository(
    val context: SaveData
) {


    fun save(boardGame: List<BoardGame>) {

    }
}
