package com.hrandika.seng31323_2023_kmm

import RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.call.*
import io.ktor.client.request.*

class Greeting {
    private val platform: Platform = getPlatform()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    fun hello() : String = "Hello from ${platform.name}"

    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        var firstSuccessLaunch = rockets.first { it.success == true }
        return "Hello, ${platform.name}!" +
                "\nThere are only ${daysUntilNewYear()} days left until New year \n" +
                "\nThe last successful launch was ${firstSuccessLaunch.dateUTC} 🚀"
    }
}