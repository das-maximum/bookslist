package de.quinesoft.bookslist.lookup

import kotlinx.serialization.Serializable

@Serializable
data class OLType(val key: String)

@Serializable
data class OLTime(val type: String, val value: String)

@Serializable
data class OLBook(
    val type: OLType,
    val title: String,
    val source_records: List<String>,
    val isbn_10: List<String>,
    val isbn_13: List<String>,
    val physical_format: String,
    val works: List<OLType>,
    val key: String,
    val latest_revision: Int,
    val revision: Int,
    val created: OLTime,
    val last_modified: OLTime
)
