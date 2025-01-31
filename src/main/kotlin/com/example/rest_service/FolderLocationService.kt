package com.example.rest_service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Service
class FolderLocationService(
    @Value("\${path.storage}") private val storagePathString: String
) {
    fun getStoragePath(): Path {
        val storagePath = Paths.get(storagePathString)
        Files.createDirectories(storagePath)

        return storagePath
    }
}