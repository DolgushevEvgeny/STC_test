package com.eugene_dolgushev.contact.contactList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.eugene_dolgushev.contact.contactList.di.ContactListDICompanion
import com.eugene_dolgushev.contact.contactList.presentation.adapter.ContactAdapter
import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.stc.R
import com.eugene_dolgushev.stc.databinding.ContactListFragmentBinding

class ContactListFragment : Fragment() {

    private val mViewModel: ContactListViewModel by lazy {
        viewModel(
            ContactListDICompanion.getContactListUseCase,
            ContactListDICompanion.deleteContactUseCase
        )
    }
    private val mContactAdapter = ContactAdapter(onDeleteItemClicked = {
        mViewModel.showContactDeleteDialog(it)
    })

    private lateinit var mViewBinding: ContactListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewBinding = ContactListFragmentBinding.inflate(inflater, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        subscribeToViewModel()
        with(mViewBinding) {
            newContactButton.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.contactAddFragment)
            }
        }
    }

    private fun prepareRecyclerView() = with(mViewBinding) {
        contactList.layoutManager = LinearLayoutManager(
            this@ContactListFragment.requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        contactList.adapter = mContactAdapter
    }

    private fun subscribeToViewModel() = with(mViewModel) {
        contactList.observe(viewLifecycleOwner) {
            mViewBinding.emptyListTextView.isVisible = it.isEmpty()
            mViewBinding.contactList.isVisible = it.isNotEmpty()
            mContactAdapter.submitList(it)
        }
        deleteContactEvent.observe(viewLifecycleOwner) { contact ->
            contact?.let {
                this@ContactListFragment.showContactDeleteDialog(it)
            }
        }
    }

    private fun showContactDeleteDialog(contact: Contact) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(getString(R.string.contact_delete_title))
        dialog.setPositiveButton(getString(R.string.yes)) { _, _ ->
            mViewModel.deleteContact(contact)
        }
        dialog.setNegativeButton(getString(R.string.no)) { _, _ ->
            mViewModel.cancelDeleteContact()
        }
        dialog.show()
    }
}