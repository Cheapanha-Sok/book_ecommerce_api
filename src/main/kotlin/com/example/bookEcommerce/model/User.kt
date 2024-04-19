package com.example.bookEcommerce.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Long?=null,
    @Column(name = "first_name")
    var firstName :String?=null,
    @Column(name = "last_name")
    var lastName :String ?=null,
    @Column(unique = true)
    @field:Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @field:NotEmpty(message = "Email cannot be empty")
    var email :String ?=null,
    var password :String ?=null,
    @Column(name = "phone_number")
    var phoneNumber :String?=null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id" , referencedColumnName = "id")
    var role : Role?=null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var carts : List<Cart> ? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var bookUsers : List<BookUser> ? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var invoices : List<Invoice>?=null
)