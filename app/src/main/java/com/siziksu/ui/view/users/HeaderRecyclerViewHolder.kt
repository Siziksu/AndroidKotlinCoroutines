package com.siziksu.ui.view.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.user_list_header.view.headerSubtitle
import kotlinx.android.synthetic.main.user_list_header.view.headerTitle

internal class HeaderRecyclerViewHolder(view: View) : ViewHolder(view) {

    val headerTitle: TextView = view.headerTitle
    val headerSubTitle: TextView = view.headerSubtitle
}
