package com.study.kotlin.security.member.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.growth.task.user.entity.Users
import com.study.kotlin.security.common.status.ROLE
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime

data class UserRequest(
    @field:NotBlank
    @field:Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{8,20}\$",
        message = "영문, 숫자, 특수문자를 포함한 8-20자리로 입력해주세요"
    )

    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,
) {
    val name: String
        get() = _name!!
    val email: String
        get() = _email!!
    val password: String
        get() = _password!!

    fun toUser(): Users =
        Users(name = name, email = email, password = password, role = ROLE.USER)
}

data class LoginDto(
    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @JsonProperty("password")
    private val _password: String?
) {
    val name: String
        get() = _name!!
    val password: String
        get() = _password!!
}

data class MemberDtoResponse(
    val userId: Long,
    val name: String,
    val role: ROLE,
    val createdAt: LocalDateTime,
)
