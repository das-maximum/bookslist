package de.quinesoft.bookslist.cli

fun parseCommand(arguments: Array<String>): Command {
    val separated = arguments.map { it.trim() }

    if (separated.isEmpty()) return UnknownCommand("No command was passed")

    val command = separated[0]
    val parameter = if (separated.size > 1) separated[1] else ""
    return when (command) {
        "add" -> AddCommand(parameter)
        "list" -> ListCommand(parameter)
        "read" -> ReadCommand(parameter)
        "search" -> SearchCommand(parameter)
        else -> UnknownCommand("Unknown command '$command'")
    }
}

sealed interface Command {
    fun run()
}

class AddCommand(private val isbn: String) : Command {
    override fun run() {
        println("Adding $isbn")
    }
}

class ListCommand(private val subcommand: String) : Command {
    override fun run() {
        println("Listing $subcommand")
    }
}

class ReadCommand(private val isbnOrId: String) : Command {
    override fun run() {
        println("Setting $isbnOrId to read")
    }
}

class SearchCommand(private val term: String) : Command {
    override fun run() {
        println("Searching for $term")
    }
}

class UnknownCommand(private val msg: String) : Command {
    override fun run() {
        println(msg)
    }
}