package com.example.bookEcommerce.model

import jakarta.persistence.*


@Entity
@Table(name = "book_user")
data class BookUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,
    @Column(name = "total_book")
    var totalBook: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    var user : User?=null,

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY , mappedBy = "bookUser")
    var bookUserItems : List<BookUserItem>?=null
)