package carolinacota.boardgames.domain

interface BoardGameRepository<T> {
    fun save(item: T)
}