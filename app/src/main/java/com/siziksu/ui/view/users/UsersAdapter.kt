package com.siziksu.ui.view.users

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siziksu.ui.R
import com.siziksu.ui.model.User

class UsersAdapter(private val context: Context?, private val manager: UsersRecyclerContract.Manager?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
                                                                                                         UsersRecyclerContract.Adapter {

    private var layoutManager: LinearLayoutManager? = null

    init {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UsersViewHolder -> {
                val user = manager?.getItem(position)
                holder.userName.text = user?.name
                holder.userUsername.text = user?.username ?: "N/A"
            }
        }
    }

    override fun getItemCount(): Int {
        return manager?.count ?: 0
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return layoutManager as LinearLayoutManager
    }

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return this
    }

    override fun showItems(users: List<User>) {
        manager?.showItems(this, users)
    }
}