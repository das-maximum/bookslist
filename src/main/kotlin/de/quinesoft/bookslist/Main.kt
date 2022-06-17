package de.quinesoft.bookslist

import de.quinesoft.bookslist.biz.BookService
import de.quinesoft.bookslist.cli.parseCommand

fun main(args: Array<String>) {

    val bookService = BookService(dao = TODO(), lookupService = TODO())

    val action = parseCommand(args)
    action.run(bookService)
}
