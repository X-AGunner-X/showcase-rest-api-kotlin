package com.example.rest_service

import org.springframework.stereotype.Service

@Service
class TrackService(private val trackRepository: TrackRepository) {

    fun processTrack(track: Track): Unit {
        trackRepository.appendTrackData(track)
    }
}