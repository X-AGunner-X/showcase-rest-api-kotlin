package com.example.rest_service

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TrackController(private val trackService: TrackService) {

    @PostMapping("/track")
    fun trackRequest(@RequestBody track: Track): ResponseEntity<String> {
        trackService.processTrack(track)

        return ResponseEntity.ok("ok")
    }
}