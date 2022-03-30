package com.eugene_dolgushev

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.loadFragment(
    fragment: Fragment,
    containerId: Int,
    addToBackStack: Boolean = false
) {
    val fragmentTransaction = this.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(containerId, fragment)
    if (addToBackStack) {
        fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
    }
    fragmentTransaction.commit()
}