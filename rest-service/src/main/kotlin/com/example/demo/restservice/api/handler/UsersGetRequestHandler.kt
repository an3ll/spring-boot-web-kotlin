package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.UserService
import org.springframework.stereotype.Component


@Component
open class UsersGetRequestHandler(private val userService: UserService) {

  data class Response(
      val users: List<UserGetByIdRequestHandler.Response>
  )

  fun handleRequest(): Response {
    val users = userService.getUsers()

    return Response(users
        .map { (id, firstName, lastName, email) ->
          UserGetByIdRequestHandler.Response(
              id = id,
              firstName = firstName,
              lastName = lastName,
              email = email
          )
        }
    )
  }
}

