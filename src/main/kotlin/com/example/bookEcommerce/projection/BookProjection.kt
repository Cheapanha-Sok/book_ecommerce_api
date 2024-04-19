package com.example.bookEcommerce.projection

import java.sql.Date

interface BookProjection {
    fun getId():Long
    fun getName():String
    fun getPrice() : Float
    fun getReleaseAt( ):Date
    fun getAuthor() : AuthorProjection
    fun getCategory() : CategoryProjection

    interface CategoryProjection{
        fun getId():Long
        fun getName():String
    }
    interface AuthorProjection {
        fun getId():Long
        fun getName():String
        fun getGender() :String
    }
}