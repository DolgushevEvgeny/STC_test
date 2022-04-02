package com.eugene_dolgushev.contact.contactList.presentation

import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.extension.getViewModel

fun ContactListFragment.viewModel(
    getContactListUseCase: GetContactListUseCase,
    deleteContactUseCase: DeleteContactUseCase
) = getViewModel {
    ContactListViewModel(
        getContactListUseCase = getContactListUseCase,
        deleteContactUseCase = deleteContactUseCase
    )
}