package com.growth.task.user.controller

import com.study.kotlin.security.member.dto.UserRequest
import com.study.kotlin.security.member.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/api/users")
@RestController
@Tag(name = "User", description = "User API Document")
class UserController(
    private val userService: UserService
) {

    /**
     * 회원 가입
     */
    @PostMapping
    @ResponseStatus(CREATED)
    fun signUp(@RequestBody @Valid userRequest: UserRequest): String {
        val resultMessage: String = userService.signUp(userRequest)
        return resultMessage
    }
}
