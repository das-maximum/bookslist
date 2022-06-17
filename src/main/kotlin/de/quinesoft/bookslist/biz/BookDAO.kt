package de.quinesoft.bookslist.biz

import de.quinesoft.bookslist.domain.Book

interface BookDAO {
    fun store(book: Book)

    fun getAll(): List<Book>

    fun get(isbn: String): Book

    fun get(id: Int): Book

    fun latestId(): Int
}