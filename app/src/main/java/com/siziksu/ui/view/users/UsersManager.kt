package com.siziksu.ui.view.users

import com.siziksu.ui.model.User

internal class UsersManager : UsersRecyclerContract.Manager {

    private val contacts = ArrayList<User>()

    override val count: Int
        get() = contacts.size

    override fun showItems(adapter: UsersRecyclerContract.Adapter, list: List<User>) {
        contacts.clear()
        contacts.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun getItem(item: Int): User {
        return contacts[item]
    }
}