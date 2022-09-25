package com.example.usermanagement.repository

import com.example.usermanagement.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.nama like %:query%")
    fun findUserByName(@Param("query")query: String): List<User>
}