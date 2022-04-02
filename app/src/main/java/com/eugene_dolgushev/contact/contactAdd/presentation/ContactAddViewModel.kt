package com.eugene_dolgushev.contact.contactAdd.presentation

import SingleLiveEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactAdd.domain.models.Result
import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase

class ContactAddViewModel(
    private val addContactUseCase: AddContactUseCase
) : ViewModel() {

    val addContactErrorEvent: LiveData<String>
        get() = mMutableErrorEvent

    val addContactSuccessEvent: LiveData<Unit>
        get() = mMutableSuccessEvent

    private val mMutableErrorEvent = SingleLiveEvent<String>()
    private val mMutableSuccessEvent = SingleLiveEvent<Unit>()

    fun addContact(params: AddContactParams) {
        when (val result = addContactUseCase.execute(params)) {
            is Result.Error -> mMutableErrorEvent.value = result.error
            Result.Success -> mMutableSuccessEvent.call()
        }
    }
}