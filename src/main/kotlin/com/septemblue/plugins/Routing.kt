package com.septemblue.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {
            val responseObject = UserResponse("Raffael", "raffael.com")
            call.respond(responseObject)
        }
        get("/headers") {
            call.response.headers.append("server-name", "KtorServer")
        }
        get("/filedownload") {
            //get the file
            val file = File("pictures/yatora.png")

            //add header to download file
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName,
                    "downloadableYatora.jpg"
                ).toString()
            )

            call.respondFile(file)
        }
        get("/fileopen") {
            //get the file
            val file = File("pictures/Makimaa.jpg")

            //add header to download file
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Inline.withParameter(
                    ContentDisposition.Parameters.FileName,
                    "Open Makimaa.jpg"
                ).toString()
            )

            call.respondFile(file)
        }
    }
}
@kotlinx.serialization.Serializable
data class UserResponse(
    val name: String,
    val email: String
)