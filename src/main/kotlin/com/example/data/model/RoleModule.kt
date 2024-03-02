package com.example.data.model

import com.example.utils.Constants

enum class RoleModule{
    ADMIN, MODERATOR, CLIENT
}

fun String.getRoleByString(): RoleModule {
    return when(this){
        Constants.Role.ADMIN -> RoleModule.ADMIN
        Constants.Role.MODERATOR -> RoleModule.MODERATOR
        else -> RoleModule.CLIENT
    }
}

fun RoleModule.getStringByRole(): String {
    return when(this){
        RoleModule.ADMIN -> Constants.Role.ADMIN
        RoleModule.MODERATOR -> Constants.Role.MODERATOR
        else -> Constants.Role.CLIENT
    }
}