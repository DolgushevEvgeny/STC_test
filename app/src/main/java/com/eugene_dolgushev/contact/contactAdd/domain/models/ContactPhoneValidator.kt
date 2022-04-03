package com.eugene_dolgushev.contact.contactAdd.domain.models

class ContactPhoneValidator {

    external fun validatePhone(phone: String): Boolean

    companion object {

        init {
            System.loadLibrary("native-lib")
        }
    }
}