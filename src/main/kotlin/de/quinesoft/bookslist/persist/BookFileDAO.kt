package de.quinesoft.bookslist.persist

import de.quinesoft.bookslist.biz.BookDAO
import de.quinesoft.bookslist.domain.Book
import java.nio.file.Paths

class BookFileDAO: BookDAO {
    val basePath = Paths.get("~/.bookslist/")

    override fun store(book: Book) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun get(isbn: String): Book {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Book {
        TODO("Not yet implemented")
    }

    override fun latestId(): Int {
        TODO("Not yet implemented")
    }
}