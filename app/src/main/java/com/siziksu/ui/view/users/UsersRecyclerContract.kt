package com.siziksu.ui.view.users

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.siziksu.ui.model.User

interface UsersRecyclerContract {

    interface Adapter {

        fun getLayoutManager(): RecyclerView.LayoutManager

        fun getAdapter(): RecyclerView.Adapter<*>

        fun showItems(users: List<User>?)

        fun setOnItemClickListener(onItemClick: (View, Int) -> Unit)

        fun notifyDataSetChanged()
    }

    interface Manager {

        val count: Int

        fun showItems(adapter: Adapter, list: List<User>)

        fun getItem(item: Int): User
    }
}