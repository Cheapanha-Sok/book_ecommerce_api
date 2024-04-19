package com.example.bookEcommerce.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name = "roles")
@JsonIgnoreProperties("users")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String? = null,
    @OneToMany(mappedBy = "role" , fetch = FetchType.LAZY)
    var users : List<User>?=null
)