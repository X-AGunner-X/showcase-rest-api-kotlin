package com.example.rest_service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class TrackServiceTest {

    private lateinit var trackService: TrackService
    private lateinit var trackRepositoryMock: TrackRepository

    @BeforeEach
    fun setup() {
        trackRepositoryMock = mock(TrackRepository::class.java)
        trackService = TrackService(trackRepositoryMock)
    }

    @Test
    fun `should call append method on track repository`() {
        val trackDummy = Track("uuid", "whatever-name", 42)

        trackService.processTrack(trackDummy)

        verify(trackRepositoryMock, times(1)).appendTrackData(trackDummy)
    }
}