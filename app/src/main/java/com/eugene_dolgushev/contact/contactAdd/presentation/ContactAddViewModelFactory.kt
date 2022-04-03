package com.eugene_dolgushev.contact.contactAdd.presentation

import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.extension.getViewModel

fun ContactAddFragment.viewModel(
    addContactUseCase: AddContactUseCase,
) = getViewModel {
    ContactAddViewModel(
        addContactUseCase = addContactUseCase
    )
}