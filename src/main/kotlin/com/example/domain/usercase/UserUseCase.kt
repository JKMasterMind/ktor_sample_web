package com.example.domain.usercase


import com.example.authentification.JwtService
import com.example.data.model.UserModel
import com.example.domain.repository.UserRepository

class UserUseCase(
    private val repositoryImpl: UserRepository,
    private val jwtService: JwtService
) {

    suspend fun createuser(userModel: UserModel) = repositoryImpl.insertUser(userModel = userModel)
    suspend fun findUserByEmail(email: String) = repositoryImpl.getUserByEmail(email = email)
    fun generateToken(userModel: UserModel): String = jwtService.generateToken(user = userModel)

}