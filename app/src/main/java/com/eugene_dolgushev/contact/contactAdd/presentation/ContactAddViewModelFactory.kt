package com.eugene_dolgushev.contact.contactAdd.presentation

import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.contact.contactList.presentation.ContactListFragment
import com.eugene_dolgushev.contact.contactList.presentation.ContactListViewModel
import com.eugene_dolgushev.stc.getViewModel

fun ContactAddFragment.viewModel(
    addContactUseCase: AddContactUseCase,
    getContactListUseCase: GetContactListUseCase,
) = getViewModel {
    ContactAddViewModel(
        addContactUseCase = addContactUseCase,
        getContactListUseCase = getContactListUseCase,
    )
}