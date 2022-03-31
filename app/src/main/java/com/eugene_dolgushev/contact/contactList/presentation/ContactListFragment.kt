package com.eugene_dolgushev.contact.contactList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eugene_dolgushev.contact.contactList.di.ContactListDICompanion
import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactAdd.domain.models.Result
import com.eugene_dolgushev.contact.contactList.presentation.adapter.ContactAdapter
import com.eugene_dolgushev.stc.databinding.ContactListFragmentBinding

class ContactListFragment : Fragment() {

    private val viewModel: ContactListViewModel by lazy {
        viewModel(
            ContactListDICompanion.addContactUseCase,
            ContactListDICompanion.getContactListUseCase,
            ContactListDICompanion.deleteContactUseCase
        )
    }
    private val contactAdapter = ContactAdapter(onDeleteItemClicked = {
        viewModel.deleteContact(it)
    })

    private lateinit var viewBinding: ContactListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = ContactListFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        subscribeToViewModel()
        with(viewBinding) {
            addContactButton.setOnClickListener {
                viewModel.addContact(AddContactParams("2", "+99999999999")) { result ->
                    when (result) {
                        is Result.Error -> Unit
                        Result.Success -> Unit
                    }
                }
            }
        }
    }

    private fun prepareRecyclerView() = with(viewBinding) {
        contactList.layoutManager = LinearLayoutManager(
            this@ContactListFragment.requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        contactList.adapter = contactAdapter
    }

    private fun subscribeToViewModel() = with(viewModel) {
        contactList.observe(viewLifecycleOwner) {
            viewBinding.emptyListTextView.isVisible = it.isEmpty()
            viewBinding.contactList.isVisible = it.isNotEmpty()
            contactAdapter.submitList(it)
        }
    }

    companion object {
        fun newInstance() = ContactListFragment()
    }
}