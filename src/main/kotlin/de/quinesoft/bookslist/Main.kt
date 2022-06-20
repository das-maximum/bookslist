package de.quinesoft.bookslist

import de.quinesoft.bookslist.biz.BookService
import de.quinesoft.bookslist.cli.parseCommand
import de.quinesoft.bookslist.persist.BookFileDAO

fun main(args: Array<String>) {

    val fileDao = BookFileDAO()

    val bookService = BookService(dao = fileDao, lookupService = TODO())

    val action = parseCommand(args)
    action.run(bookService)
}
