package com.example.rest_service

import jakarta.validation.constraints.*

data class Track(
    @field:NotBlank(message = "uuid cannot be blank")
    //don't want it to be nullable, but found no other way to make jakarta validation work with kotlin
    //@see https://stackoverflow.com/questions/70215736/kotlin-spring-boot-bean-validation-not-working
    val uuid: String? = null,

    @field:NotBlank(message = "name cannot be blank")
    //don't want it to be nullable, but found no other way to make jakarta validation work with kotlin
    //@see https://stackoverflow.com/questions/70215736/kotlin-spring-boot-bean-validation-not-working
    val name: String? = null,

    @field:Min(value = 0, message = "count cannot be negative number")
    val count: Int? = null
)
