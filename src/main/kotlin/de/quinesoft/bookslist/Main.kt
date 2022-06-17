package de.quinesoft.bookslist

import de.quinesoft.bookslist.cli.parseCommand

fun main(args: Array<String>) {
    val action = parseCommand(args)
    action.run()
}
