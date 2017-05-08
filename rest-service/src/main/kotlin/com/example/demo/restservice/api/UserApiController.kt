package com.example.demo.restservice.api

import com.example.demo.restservice.api.handler.UserGetByIdRequestHandler
import com.example.demo.restservice.api.handler.UsersGetRequestHandler
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
open class UserApiController(
    private val userGetByIdRequestHandler: UserGetByIdRequestHandler,
    private val usersGetRequestHandler: UsersGetRequestHandler
) {

  private object ApiRequestFields {
    const val USER_ID = "user-id"
  }

  private object ApiRoutes {
    const val USER_GET_BY_ID = "/rest/users/{${ApiRequestFields.USER_ID}}"
    const val USERS_GET = "/rest/users"
  }

  @GetMapping(ApiRoutes.USER_GET_BY_ID)
  fun getUserById(@PathVariable(name = ApiRequestFields.USER_ID) userId: String)
      = userGetByIdRequestHandler.handleRequest(UserGetByIdRequestHandler.Request(id = userId))

  @GetMapping(ApiRoutes.USERS_GET)
  fun getUsers() = usersGetRequestHandler.handleRequest()
}

