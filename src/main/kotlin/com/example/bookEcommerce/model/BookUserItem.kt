package com.example.bookEcommerce.model

import jakarta.persistence.*

@Entity
@Table(name = "book_user_item")
data class BookUserItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_user_id", referencedColumnName = "id")
    var bookUser: BookUser? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    var book: Book? = null,
)