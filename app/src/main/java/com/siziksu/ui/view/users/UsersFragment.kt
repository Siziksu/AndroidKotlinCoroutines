package com.siziksu.ui.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R
import com.siziksu.ui.common.observe
import kotlinx.android.synthetic.main.fragment_users.frameLayout
import kotlinx.android.synthetic.main.fragment_users.progressBar
import kotlinx.android.synthetic.main.fragment_users.recyclerView
import org.koin.android.ext.android.get

class UsersFragment : Fragment() {

    private var viewModelProvider: UsersViewModelProvider = get()
    private val viewModel: UsersViewModelContract by lazy { ViewModelProviders.of(this, viewModelProvider).get(UsersViewModel::class.java) }

    private var adapter: UsersRecyclerContract.Adapter? = null
    private var isFirstTimeCreated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        if (isFirstTimeCreated) {
            viewModel.getUsers()
            isFirstTimeCreated = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun initViews() {
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = UsersRecyclerAdapter(activity, UsersRecyclerManager())
        recyclerView.adapter = adapter?.getAdapter()
        recyclerView.layoutManager = adapter?.getLayoutManager()
        observe(viewModel.usersLiveData) { users -> (adapter as UsersRecyclerAdapter).showItems(users) }
        observe(viewModel.errorLiveData) { message -> Snackbar.make(frameLayout, message ?: "Error: Unknown error.", Snackbar.LENGTH_SHORT).show() }
        observe(viewModel.progressLiveData) { value -> value?.let { if (value) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE } }
    }
}
