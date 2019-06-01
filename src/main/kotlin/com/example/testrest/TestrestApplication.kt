package com.example.testrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TestrestApplication

fun main(args: Array<String>) {
    runApplication<TestrestApplication>(*args)
}

@RestController
class Rest {
    @GetMapping("/helloworld")
    fun get() = "world"
}
