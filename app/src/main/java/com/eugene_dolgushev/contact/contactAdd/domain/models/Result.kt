package com.eugene_dolgushev.contact.contactAdd.domain.models

sealed class Result {

    object Success : Result()
    data class Error(val error: String) : Result()
}
