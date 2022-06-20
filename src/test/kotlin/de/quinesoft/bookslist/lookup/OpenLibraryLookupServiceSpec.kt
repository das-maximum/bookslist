package de.quinesoft.bookslist.lookup

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class OpenLibraryLookupServiceSpec : WordSpec({
    val sut = OpenLibraryLookupService()

    "OpenLibraryLookupService" should {
        "parse the response correctly" {
            sut.lookupTitle("9783960091394") shouldBe "Projekt Unicorn"
        }

        "also parse response correctly" {
            sut.lookupTitle("9781950508402") shouldBe "DevOps Handbook, Second Edition"
        }
    }
})