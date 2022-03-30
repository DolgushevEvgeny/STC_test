package com.eugene_dolgushev

import com.eugene_dolgushev.contact.contactList.di.ContactListDICompanion

object ApplicationDICompanion {

    fun init() {
        ContactListDICompanion.init()
    }
}