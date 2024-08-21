package com.growth.task.user.entity

import com.study.kotlin.security.common.status.ROLE
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(nullable = false, length = 32)
    val name: String,

    @Column(nullable = false, length = 100, unique = true, updatable = false)
    val email: String,

    @Column(nullable = false, length = 128)
    var password: String,

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    val role: ROLE,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
)
