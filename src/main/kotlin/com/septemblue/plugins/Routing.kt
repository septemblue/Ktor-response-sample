package com.septemblue.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
                val responseObject = UserResponse("Raffael", "raffael.com")
                call.respond(responseObject)
        }
    }
}
@kotlinx.serialization.Serializable
data class UserResponse(
    val name: String,
    val email: String
)