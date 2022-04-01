package com.eugene_dolgushev.contact.contactAdd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eugene_dolgushev.contact.contactList.di.ContactListDICompanion
import com.eugene_dolgushev.stc.databinding.ContactAddFragmentBinding

class ContactAddFragment : Fragment() {

    private val viewModel: ContactAddViewModel by lazy {
        viewModel(
            ContactListDICompanion.addContactUseCase,
            ContactListDICompanion.getContactListUseCase
        )
    }

    private lateinit var viewBinding: ContactAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = ContactAddFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

//                viewModel.addContact(AddContactParams("2", "+99999999999")) { result ->
//                    when (result) {
//                        is Result.Error -> Unit
//                        Result.Success -> Unit
//                    }
//                }

    companion object {
        @JvmStatic
        fun newInstance() = ContactAddFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}