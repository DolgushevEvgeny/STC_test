package com.eugene_dolgushev.contact.contactList.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.stc.databinding.ContactViewHolderBinding

class ContactViewHolder(
    private val viewHolderBinding: ContactViewHolderBinding
) :
    RecyclerView.ViewHolder(viewHolderBinding.root) {

    fun bindView(contact: Contact, onDeleteItemClicked: (contact: Contact) -> Unit) {
        with(viewHolderBinding) {
            nameTextView.text = contact.name
            phoneTextView.text = contact.phone
            delete.setOnClickListener {
                onDeleteItemClicked(contact)
            }
        }
    }
}