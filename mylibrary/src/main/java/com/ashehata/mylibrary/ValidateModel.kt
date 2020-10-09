package com.ashehata.mylibrary

data class ValidateModel(
    val isValid: Boolean,
    val validateErrorType: ValidateErrorType? = null
)