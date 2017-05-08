package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.UserService
import org.springframework.stereotype.Component


@Component
open class UserGetByIdRequestHandler(private val userService: UserService) {

  data class Request(
      val id: String
  )

  data class Response(
      val id: String,
      val firstName: String,
      val lastName: String,
      val email: String
  )

  fun handleRequest(request: Request): Response {
    val user = userService.getById(request.id)

    return Response(
        id = user.id,
        firstName = user.firstName,
        lastName = user.lastName,
        email = user.email
    )
  }
}


