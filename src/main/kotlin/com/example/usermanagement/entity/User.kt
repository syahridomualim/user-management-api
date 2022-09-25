package com.example.usermanagement.entity

import com.example.usermanagement.converter.ListToStringConverter
import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val nama: String,
    val noHP: Long,
    @Column(unique = true)
    val email: String,
    @Convert(converter = ListToStringConverter::class)
    val alamat: List<String>
)
