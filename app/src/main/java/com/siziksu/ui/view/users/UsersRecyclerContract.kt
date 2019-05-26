package com.siziksu.ui.view.users

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.siziksu.ui.model.Node

interface UsersRecyclerContract {

    interface Adapter {

        fun getLayoutManager(): RecyclerView.LayoutManager

        fun getAdapter(): RecyclerView.Adapter<*>

        fun showItems(users: List<Node>?)

        fun setOnItemClickListener(onItemClick: (View, Int) -> Unit)

        fun notifyDataSetChanged()
    }

    interface Manager {

        val count: Int

        fun showItems(adapter: Adapter, list: List<Node>)

        fun getItem(position: Int): Node

        fun getItemType(position: Int): Int
    }
}