package com.example.bookEcommerce.model

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Int = 0,
    var name :String?=null,

    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
    var books : List<Book> ?=null
)