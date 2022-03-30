package com.eugene_dolgushev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eugene_dolgushev.stc.R
import com.eugene_dolgushev.contact.contactList.presentation.ContactListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(ContactListFragment.newInstance(), containerId = R.id.fragment_wrapper)
    }
}