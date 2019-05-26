package com.siziksu.ui.view.users

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.userItem
import kotlinx.android.synthetic.main.item_user.view.userName
import kotlinx.android.synthetic.main.item_user.view.userUsername

internal class UsersRecyclerViewHolder(view: View, onItemClick: ((View, Int) -> Unit)?) : RecyclerView.ViewHolder(view) {

    private val userItem: RelativeLayout = view.userItem
    val userName: TextView = view.userName
    val userUsername: TextView = view.userUsername

    init {
        userItem.setOnClickListener { item -> onItemClick?.let { it(item, adapterPosition + 1) } }
    }
}
