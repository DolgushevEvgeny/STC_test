package com.eugene_dolgushev.contact.contactAdd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.eugene_dolgushev.contact.contactAdd.di.ContactAddDICompanion
import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.extension.showSnackBar
import com.eugene_dolgushev.stc.databinding.ContactAddFragmentBinding

class ContactAddFragment : Fragment() {

    private val mViewModel: ContactAddViewModel by lazy {
        viewModel(
            ContactAddDICompanion.addContactUseCase
        )
    }

    private lateinit var mViewBinding: ContactAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewBinding = ContactAddFragmentBinding.inflate(inflater, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
        savedInstanceState?.let {
            configureNameEditText(it)
            configurePhoneEditText(it)
        }
        configureContactAddButton()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NAME_KEY, mViewBinding.nameEditText.text.toString().trim())
        outState.putString(ARG_PHONE_KEY, mViewBinding.phoneEditText.text.toString().trim())
    }

    private fun subscribeToViewModel() = with(mViewModel) {
        addContactErrorEvent.observe(viewLifecycleOwner) {
            showSnackBar(it)
        }
        addContactSuccessEvent.observe(viewLifecycleOwner) {
            Navigation.findNavController(mViewBinding.root).popBackStack()
        }
    }

    private fun configureNameEditText(savedState: Bundle) = with(mViewBinding) {
        nameEditText.setText(savedState.getString(ARG_NAME_KEY) ?: "")
    }

    private fun configurePhoneEditText(savedState: Bundle) = with(mViewBinding) {
        phoneEditText.setText(savedState.getString(ARG_PHONE_KEY) ?: "")
    }

    private fun configureContactAddButton() = with(mViewBinding) {
        addContactButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            mViewModel.addContact(AddContactParams(name, phone))
        }
    }

    companion object {
        private const val ARG_NAME_KEY = "form_name"
        private const val ARG_PHONE_KEY = "form_phone"
    }
}