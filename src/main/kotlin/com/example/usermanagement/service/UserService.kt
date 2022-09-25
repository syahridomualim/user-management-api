package com.example.usermanagement.service

import com.example.usermanagement.entity.User

interface UserService {
    fun addUser(user: User): User
    fun userByName(query: String): List<User>
    fun getUsers(): List<User>
}