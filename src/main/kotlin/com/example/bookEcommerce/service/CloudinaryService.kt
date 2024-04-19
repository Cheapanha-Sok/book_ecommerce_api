package com.example.bookEcommerce.service

import org.springframework.web.multipart.MultipartFile

interface CloudinaryService {
    fun uploadFile(file: MultipartFile, folderName: String?, fileName: String): String?
    fun removeFile(folderName :String , fileName: String) : Boolean
}