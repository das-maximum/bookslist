package de.quinesoft.bookslist

import de.quinesoft.bookslist.biz.BookService
import de.quinesoft.bookslist.cli.parseCommand
import de.quinesoft.bookslist.lookup.OpenLibraryLookupService
import de.quinesoft.bookslist.persist.BookFileDAO

fun main(args: Array<String>) {

    val fileDao = BookFileDAO()
    val olls = OpenLibraryLookupService()

    val bookService = BookService(dao = fileDao, lookupService = olls)

    val action = parseCommand(args)
    action.run(bookService)
}
