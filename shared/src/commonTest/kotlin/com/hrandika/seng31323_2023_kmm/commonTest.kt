package com.hrandika.seng31323_2023_kmm

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testHello() {
        assertTrue(Greeting().hello().contains("Hello"), "Check 'Hello' is mentioned")
    }
}