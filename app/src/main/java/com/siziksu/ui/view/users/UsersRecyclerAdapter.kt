package com.siziksu.ui.view.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siziksu.ui.R
import com.siziksu.ui.model.Header
import com.siziksu.ui.model.Node
import com.siziksu.ui.model.NodeType
import com.siziksu.ui.model.User

class UsersRecyclerAdapter(
    private val context: Context,
    private val manager: UsersRecyclerContract.Manager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    UsersRecyclerContract.Adapter {

    private var layoutManager: LinearLayoutManager? = null
    private var onItemClick: ((View, Int) -> Unit)? = null

    init {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NodeType.HEADER.value -> {
                HeaderRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.user_list_header, parent, false))
            }
            NodeType.USER.value -> {
                UserRecyclerViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)
                ) { view, position -> onItemClick?.let { it(view, (manager.getItem(position) as User).id) } }
            }
            else -> {
                UserRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false), null)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val node = manager.getItem(position)
        when (node.type) {
            NodeType.HEADER -> {
                val localHolder = holder as HeaderRecyclerViewHolder
                (node as Header).apply {
                    localHolder.headerTitle.text = title
                    localHolder.headerSubTitle.text = subtitle
                }
            }
            NodeType.USER -> {
                val localHolder = holder as UserRecyclerViewHolder
                (node as User).apply {
                    localHolder.userName.text = name
                    localHolder.userUsername.text = username
                }
            }
            else -> {
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return manager.getItemType(position)
    }

    override fun getItemCount(): Int {
        return manager.count
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return layoutManager as LinearLayoutManager
    }

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return this
    }

    override fun showItems(users: List<Node>?) {
        users?.let { manager.showItems(this, it) }
    }

    override fun setOnItemClickListener(onItemClick: (View, Int) -> Unit) {
        this.onItemClick = onItemClick
    }
}
