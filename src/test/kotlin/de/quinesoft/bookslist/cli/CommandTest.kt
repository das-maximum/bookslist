package de.quinesoft.bookslist.cli

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.should
import io.kotest.matchers.types.beOfType

class CommandTest : WordSpec({
    "parseCommand" should {
        "respond with AddCommand" {
            val action = parseCommand(arrayOf("add"))
            action should beOfType<AddCommand>()
        }

        "respond with ListComment" {
            val action = parseCommand(arrayOf("list"))
            action should beOfType<ListCommand>()
        }

        "respond with ReadComment" {
            val action = parseCommand(arrayOf("read"))
            action should beOfType<ReadCommand>()
        }

        "respond with SearchComment" {
            val action = parseCommand(arrayOf("search"))
            action should beOfType<SearchCommand>()
        }

        "respond with UnknownComment" {
            val action = parseCommand(arrayOf("sfasd"))
            action should beOfType<UnknownCommand>()
        }

    }
})