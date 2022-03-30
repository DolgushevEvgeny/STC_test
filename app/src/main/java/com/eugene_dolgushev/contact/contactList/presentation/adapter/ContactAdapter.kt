package com.eugene_dolgushev.contact.contactList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.stc.databinding.ContactViewHolderBinding

class ContactAdapter(private val onDeleteItemClicked: (contact: Contact) -> Unit) :
    ListAdapter<Contact, ContactViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val viewBinding = ContactViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContactViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = currentList[holder.bindingAdapterPosition]
        holder.bindView(contact, onDeleteItemClicked)
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact) =
            oldItem.phone == newItem.phone

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact) = oldItem == newItem
    }
}