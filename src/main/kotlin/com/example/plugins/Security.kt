package com.example.plugins


import com.example.authentification.JwtService
import com.example.data.model.RoleModule
import com.example.data.model.UserModel
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.usercase.UserUseCase
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import kotlinx.coroutines.runBlocking

fun Application.configureSecurity() {
    val jwtService = JwtService()
    val repository = UserRepositoryImpl()
    val userUseCase = UserUseCase(repository, jwtService)

    runBlocking {
        userUseCase.createuser(
            UserModel(
                id = 2,
                email = "bruh@test.com",
                login = "Bruh",
                password = "Pass",
                firstName = "Denord",
                lastName = "Gray",
                isActive = true,
                role = RoleModule.CLIENT
            )
        )
    }

    authentication {
        jwt("jwt"){
            verifier(jwtService.getVerifier())
            realm = " Service server"
            validate {
                val payload = it.payload
                val email = payload.getClaim("email").asString()
                val user = userUseCase.findUserByEmail(email = email)
                user
            }
        }
    }
    }

