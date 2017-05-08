package com.example.demo.restservice.domain

import org.springframework.stereotype.Component

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

@Component
open class UserService {

  fun getById(id: String) = User(
      id = id,
      firstName = "Hans",
      lastName = "Gruber",
      email = "hans_gruber@hotmail.com"
  )

  fun getUsers() = listOf(
      getById("1"),
      getById("2"),
      getById("3")
  )
}


