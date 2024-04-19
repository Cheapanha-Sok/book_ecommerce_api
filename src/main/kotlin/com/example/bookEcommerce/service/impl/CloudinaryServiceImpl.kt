package com.example.bookEcommerce.service.impl

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import com.example.bookEcommerce.service.CloudinaryService
import com.example.bookEcommerce.utils.anotation.Sl4JLogger
import com.example.bookEcommerce.utils.anotation.Sl4JLogger.Companion.log
import com.example.bookEcommerce.utils.constants.Constants
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
@Sl4JLogger
class CloudinaryServiceImpl(private val cloudinary: Cloudinary) : CloudinaryService {
    override fun uploadFile(file: MultipartFile, folderName: String?, fileName: String): String? {
        try {
            val options = HashMap<Any?, Any?>()
            options["folder"] = "${Constants.MAIN_FOLDER}$folderName"
            options["public_id"] = fileName
            val uploadedFile = cloudinary.uploader().upload(file.bytes, options)
            val publicId = uploadedFile["public_id"] as String?
            return cloudinary.url().secure(true).generate(publicId)
        } catch (e: Exception) {
            log.error(e.message, e)
            return null
        }
    }
    override fun removeFile(folderName :String, fileName: String) : Boolean{
        val response = cloudinary.uploader().destroy("${Constants.MAIN_FOLDER}$folderName/$fileName", ObjectUtils.emptyMap())
        return if (response["result"] == "ok"){
            true
        }else
            false
    }
}