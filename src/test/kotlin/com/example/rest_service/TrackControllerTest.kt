package com.example.rest_service

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(TrackController::class)
class TrackControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockitoBean
    private lateinit var trackServiceMock: TrackService

    private val objectMapper = ObjectMapper()

    @BeforeEach
    fun setup() {
        reset(trackServiceMock)
    }

    @Test
    fun `should call trackService and return 200 OK`() {
        val trackDummy = Track("dummy-uuid", "dummy-name", 42)
        val trackDummyJson = objectMapper.writeValueAsString(trackDummy)

        mockMvc.perform(
            post("/track")
                .contentType(MediaType.APPLICATION_JSON)
                .content(trackDummyJson)
        )
            .andExpect(status().isOk)
            .andExpect(content().string("ok"))

        verify(trackServiceMock, times(1)).processTrack(trackDummy)
    }
}