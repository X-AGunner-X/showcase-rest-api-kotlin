package com.example.rest_service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.mockito.Mockito.*
import java.nio.file.Path
import kotlin.io.path.readLines

class FileStorageRepositoryTest {

    @TempDir
    lateinit var tempFolder: Path

    private lateinit var folderLocationServiceMock: FolderLocationService
    private lateinit var fileStorageRepository: FileStorageRepository

    @BeforeEach
    fun setup() {
        folderLocationServiceMock = mock(FolderLocationService::class.java)
        `when`(folderLocationServiceMock.getStoragePath()).thenReturn(tempFolder)

        fileStorageRepository = FileStorageRepository(folderLocationServiceMock)
    }

    @Test
    fun `should append track data to file`() {
        val track = Track(uuid = "123abc", name = "Test Track", count = 42)

        fileStorageRepository.appendTrackData(track)

        val trackDataFile = tempFolder.resolve("track-data.jsonl")
        val lines = trackDataFile.readLines()

        Assertions.assertEquals(1, lines.size)
        val expectedJson = jacksonObjectMapper().writeValueAsString(track)
        Assertions.assertEquals(expectedJson, lines.first())
    }
}