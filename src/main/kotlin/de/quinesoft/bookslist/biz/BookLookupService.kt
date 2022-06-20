package de.quinesoft.bookslist.biz

interface BookLookupService {
    suspend fun lookupTitle(isbn: String): String?
}