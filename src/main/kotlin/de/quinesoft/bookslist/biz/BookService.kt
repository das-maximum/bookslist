package de.quinesoft.bookslist.biz

import de.quinesoft.bookslist.domain.Book
import io.kotest.common.runBlocking
import java.util.Optional

class BookService(private val dao: BookDAO, private val lookupService: BookLookupService) {

    fun createBook(isbn: String, alreadyRead: Boolean = false): Optional<Book> {
        return runBlocking {
            val title = lookupService.lookupTitle(isbn)
            if (title == null) {
                return@runBlocking Optional.empty()
            } else {
                val latestId = dao.latestId()
                val newBook = Book(latestId, isbn, title, read = alreadyRead)
                dao.store(newBook)
                return@runBlocking Optional.of(newBook)
            }
        }
    }

    fun markBookAsRead(id: Int) {
        val book = dao.get(id)
        val updatedBook = book.copy(read = true)
        dao.store(updatedBook)
    }

    fun listBooks(read: Boolean?): List<Book> =
        if (read == null) dao.getAll()
        else if (read) dao.getAll().filter { it.read }
        else dao.getAll().filter { !it.read }

    fun searchBooks(searchTerm: String): List<Book> =
        dao.getAll().filter { it.isbn == searchTerm || it.title.contains(searchTerm) }
}