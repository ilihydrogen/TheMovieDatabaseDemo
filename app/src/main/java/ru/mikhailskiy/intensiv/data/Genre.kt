package ru.mikhailskiy.intensiv.data

data class Genre(val id: Int, val name: String) {

    companion object {
        fun getGenresAsString(genres: List<Genre>): String {
            var result = ""
            genres.map { result += it.name + " " }
            return result.trim().replace(" ", ", ")
        }
    }
}