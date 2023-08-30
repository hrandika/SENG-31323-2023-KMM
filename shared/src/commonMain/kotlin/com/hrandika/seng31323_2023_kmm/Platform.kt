package com.hrandika.seng31323_2023_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

