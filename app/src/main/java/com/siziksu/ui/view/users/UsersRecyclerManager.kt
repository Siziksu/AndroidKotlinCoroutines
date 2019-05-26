package com.siziksu.ui.view.users

import com.siziksu.ui.model.Node

internal class UsersRecyclerManager : UsersRecyclerContract.Manager {

    private val items = ArrayList<Node>()

    override val count: Int
        get() = items.size

    override fun showItems(adapter: UsersRecyclerContract.Adapter, list: List<Node>) {
        items.clear()
        items.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun getItem(position: Int): Node {
        return items[position]
    }

    override fun getItemType(position: Int): Int {
        return items[position].type.value
    }
}