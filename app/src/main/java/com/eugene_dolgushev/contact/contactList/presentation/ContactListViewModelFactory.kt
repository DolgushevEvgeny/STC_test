package com.eugene_dolgushev.contact.contactList.presentation

import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.stc.getViewModel

fun ContactListFragment.viewModel(
    addContactUseCase: AddContactUseCase,
    getContactListUseCase: GetContactListUseCase,
    deleteContactUseCase: DeleteContactUseCase
) = getViewModel {
    ContactListViewModel(
        addContactUseCase = addContactUseCase,
        getContactListUseCase = getContactListUseCase,
        deleteContactUseCase = deleteContactUseCase
    )
}