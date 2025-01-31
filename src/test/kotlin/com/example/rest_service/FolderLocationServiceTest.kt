package com.example.rest_service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.io.TempDir
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.context.TestPropertySource
import java.nio.file.Files
import java.nio.file.Path

@ExtendWith(MockitoExtension::class)
@TestPropertySource(properties = ["path.storage=/tmp/test-storage"])
class FolderLocationServiceTest {

    @Test
    fun `should return correct storage path and create directory`(@TempDir tempDir: Path) {
        val pathDummy = tempDir.toString()
        val service = FolderLocationService(pathDummy)

        val result = service.getStoragePath()

        assertEquals(tempDir, result)
        assert(result.toFile().exists())

        Files.delete(result)
        assertFalse(Files.exists(result))
    }

}