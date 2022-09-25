package com.example.usermanagement.model

data class UserRequest(
    val nama: String,
    val noHP: Long,
    val email: String,
    val alamat: List<String>,
)
