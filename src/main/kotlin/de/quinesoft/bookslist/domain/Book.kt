package de.quinesoft.bookslist.domain

data class Book(val id: Int, val isbn: String, val title: String, val read: Boolean = false)