package de.quinesoft.bookslist.biz

interface BookLookupService {
    fun lookupTitle(isbn: String): String
}