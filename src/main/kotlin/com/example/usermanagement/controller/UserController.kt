package com.example.usermanagement.controller

import com.example.usermanagement.entity.User
import com.example.usermanagement.model.HttpResponse
import com.example.usermanagement.model.UserRequest
import com.example.usermanagement.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/", "/user")
class UserController @Autowired constructor(
    private val userService: UserService,
) {

    @PostMapping("/save")
    fun addUser(@RequestBody user: UserRequest): HttpResponse {

        val userData = User(
            id = null,
            nama = user.nama,
            noHP = user.noHP,
            email = user.email,
            alamat = user.alamat
        )

        return HttpResponse(
            time = LocalDateTime.now(),
            statusCode = HttpStatus.CREATED.value(),
            httpStatus = HttpStatus.CREATED,
            reason = HttpStatus.CREATED.reasonPhrase,
            message = "Successfully created user",
            data = mapOf(Pair("users", userService.addUser(userData)))
        )
    }

    @GetMapping("/{query}")
    fun getUserByName(@PathVariable("query") query: String): HttpResponse {
        val listUsersByName = userService.userByName(query)

        return HttpResponse(
            time = LocalDateTime.now(),
            statusCode = HttpStatus.OK.value(),
            httpStatus = HttpStatus.OK,
            reason = HttpStatus.OK.reasonPhrase,
            message = "Successfully get data",
            data = mapOf(Pair("users", listUsersByName))
        )
    }

    @GetMapping("/all")
    fun getUsers(): HttpResponse {
        val listUsers = userService.getUsers()

        return HttpResponse(
            time = LocalDateTime.now(),
            statusCode = HttpStatus.OK.value(),
            httpStatus = HttpStatus.OK,
            reason = HttpStatus.OK.reasonPhrase,
            message = "Successfully get data",
            data = mapOf(Pair("users", listUsers))
        )
    }


}