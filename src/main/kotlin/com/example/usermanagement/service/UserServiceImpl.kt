package com.example.usermanagement.service

import com.example.usermanagement.entity.User
import com.example.usermanagement.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository
) : UserService {
    override fun addUser(user: User): User {
        return userRepository.save(user)
    }

    override fun userByName(query: String): List<User> {
        return userRepository.findUserByName(query)
    }

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }

}