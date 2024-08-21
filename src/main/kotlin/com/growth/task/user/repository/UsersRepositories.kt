package com.growth.task.user.repository

import com.growth.task.user.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
    fun existsByEmail(email: String): Boolean
    fun findByName(name: String): Users?
}
