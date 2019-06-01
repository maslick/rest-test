package com.example.testrest

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class TestrestApplicationTests {
    @LocalServerPort var port: Int? = null
    @Autowired private lateinit var restTemplate: TestRestTemplate

    @Test
    fun testingMainEndpoint() {
        val url = "http://localhost:$port/helloworld"
        val resp = restTemplate.exchange(url, GET, null, String::class.java)
        assertEquals(resp.statusCode, OK)
    }

    @Test
    fun testingTestEndpoint() {
        val url = "http://localhost:$port/test"
        val resp = restTemplate.exchange(url, GET, null, String::class.java)
        assertEquals(resp.statusCode, OK)
    }
}

@RestController
class TestRest {
    @GetMapping("/test")
    fun get() = "test"
}