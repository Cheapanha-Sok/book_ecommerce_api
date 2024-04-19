package com.example.bookEcommerce.model

import jakarta.persistence.*
import java.sql.Date


@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var price: Float? = null,
    @Column(name = "release_at")
    var releaseAt: Date? = null,
    @Column(name = "book_cover")
    var bookCover: String? = null,
    @Column(name = "book_pdf")
    var bookPdf: String? = null,

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    var category: Category? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    var author: Author? = null,

    @OneToMany(mappedBy = "book" , fetch = FetchType.LAZY)
    var bookUserItems: List<BookUserItem>? = null,

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    var cartItems: List<CartItem>? = null,

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    var invoiceItems: List<InvoiceItem>? = null,
)