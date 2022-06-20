package de.quinesoft.bookslist.lookup

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class OpenLibraryLookupServiceSpec : WordSpec({
    val sut = OpenLibraryLookupService()

    "OpenLibraryLookupService" should {
        "parse the response correctly" {
            sut.lookupTitle("9783960091394") shouldBe "Projekt Unicorn"
        }
    }
})