package com.example.bookEcommerce.model

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Long?=null,
    var name : String ? =null,
    var gender :String?=null,

    @OneToMany(mappedBy = "author" , fetch = FetchType.LAZY)
    var books : List<Book>?=null
)