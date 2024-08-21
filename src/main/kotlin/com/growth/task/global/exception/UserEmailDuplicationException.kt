package com.growth.task.global.exception

class UserEmailDuplicationException(
    val fieldName: String = "",
    message: String = "이미 사용중인 이메일입니다."
) : RuntimeException(message)
