package com.example.rest_service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files

@Service
class FileStorageRepository(folderLocationService: FolderLocationService): TrackRepository {

    private val jacksonObjectMapper = jacksonObjectMapper()
    private val trackDataFile = folderLocationService.getStoragePath().resolve("track-data.jsonl")

    init {
        if (!Files.exists(trackDataFile)) {
            Files.createFile(trackDataFile)
        }
    }

    override fun appendTrackData(track: Track): Unit {
        val jsonData = jacksonObjectMapper.writeValueAsString(track)
        File(trackDataFile.toString()).appendText("${jsonData}\n")
    }
}