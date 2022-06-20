package de.quinesoft.bookslist.lookup

import de.quinesoft.bookslist.biz.BookLookupService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

class OpenLibraryLookupService: BookLookupService {

    private val baseUrl = "https://openlibrary.org/isbn/{ISBN}.json"
    private val client = HttpClient(CIO)

    override suspend fun lookupTitle(isbn: String): String? {
        if (isbn.isBlank()) throw IllegalArgumentException("ISBN is blank")

        val url = baseUrl.replace("{ISBN}", isbn)
        val response = client.get(url)

        if (response.status != HttpStatusCode.OK) return null

        val responseBody: String = response.body()
        val book = Json.decodeFromString(OLBook.serializer(), responseBody)

        return book.title
    }

}