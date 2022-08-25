package carolinacota.boardgames.domain

interface Repository<T> {
    fun save(item: List<T>)
}