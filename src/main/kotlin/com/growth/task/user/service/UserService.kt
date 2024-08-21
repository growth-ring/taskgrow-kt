package com.study.kotlin.security.member.service

import com.growth.task.global.exception.UserEmailDuplicationException
import com.growth.task.user.entity.Users
import com.growth.task.user.repository.UserRepository
import com.study.kotlin.security.member.dto.UserRequest
import jakarta.transaction.Transactional
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Transactional
@Service
class UserService(
    private val userRepository: UserRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val passwordEncoder: PasswordEncoder
) {

    /**
     * 회원가입
     */
    fun signUp(userRequest: UserRequest): String {
        // ID 중복 검사
        if (userRepository.existsByEmail(userRequest.email)) {
            throw UserEmailDuplicationException(userRequest.email)
        }

        val user: Users = userRequest.toUser()
        user.password = passwordEncoder.encode(userRequest.password)

        userRepository.save(user)
        return "회원가입이 완료되었습니다."
    }
}
