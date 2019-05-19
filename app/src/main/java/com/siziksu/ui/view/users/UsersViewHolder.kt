package com.siziksu.ui.view.users

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.siziksu.ui.R
import com.siziksu.ui.view.detail.UserDetailFragment
import kotlinx.android.synthetic.main.item_user.view.userItem
import kotlinx.android.synthetic.main.item_user.view.userName
import kotlinx.android.synthetic.main.item_user.view.userUsername

internal class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val userItem: RelativeLayout = view.userItem
    val userName: TextView = view.userName
    val userUsername: TextView = view.userUsername

    init {
        userItem.setOnClickListener { it.findNavController().navigate(R.id.toUserDetail, UserDetailFragment.setArguments(adapterPosition + 1)) }
    }
}
