package de.quinesoft.bookslist.biz

import de.quinesoft.bookslist.domain.Book

class BookService(private val dao: BookDAO, private val lookupService: BookLookupService) {

    fun createBook(isbn: String, alreadyRead: Boolean = false) {
        val title = lookupService.lookupTitle(isbn)
        val latestId = dao.latestId()
        val newBook = Book(latestId, isbn, title, read = alreadyRead)
        dao.store(newBook)
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