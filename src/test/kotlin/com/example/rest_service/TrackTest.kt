package com.example.rest_service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import jakarta.validation.Validation
import jakarta.validation.Validator

class TrackTest {

    private val validator: Validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun `should validate valid Track object`() {
        val track = Track(uuid = "123", name = "Track A", count = 5)

        val violations = validator.validate(track)

        assertTrue(violations.isEmpty()) // No validation errors expected
    }

    @Test
    fun `should fail validation when uuid is blank`() {
        val track = Track(uuid = "", name = "Track A", count = 5)

        val violations = validator.validate(track)

        assertFalse(violations.isEmpty()) // Should fail validation
        assertEquals(1, violations.size)
        assertEquals("uuid cannot be blank", violations.first().message)
    }

    @Test
    fun `should fail validation when name is blank`() {
        val track = Track(uuid = "123", name = "", count = 5)

        val violations = validator.validate(track)

        assertFalse(violations.isEmpty()) // Should fail validation
        assertEquals(1, violations.size)
        assertEquals("name cannot be blank", violations.first().message)
    }

    @Test
    fun `should fail validation when count is negative`() {
        val track = Track(uuid = "123", name = "Track A", count = -1)

        val violations = validator.validate(track)

        assertFalse(violations.isEmpty()) // Should fail validation
        assertEquals(1, violations.size)
        assertEquals("count cannot be negative number", violations.first().message)
    }

    @Test
    fun `should pass validation when count is null`() {
        val track = Track(uuid = "123", name = "Track A", count = null)

        val violations = validator.validate(track)

        assertTrue(violations.isEmpty()) // No validation errors expected
    }

    @Test
    fun `should pass validation when count is missing`() {
        val track = Track(uuid = "123", name = "Track A")

        val violations = validator.validate(track)

        assertTrue(violations.isEmpty())
    }
}
