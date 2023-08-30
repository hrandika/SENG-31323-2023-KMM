package com.hrandika.seng31323_2023_kmm

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().hello().contains("Android"))
    }
}