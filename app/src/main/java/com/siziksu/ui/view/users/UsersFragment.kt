package com.siziksu.ui.view.users

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R
import com.siziksu.ui.common.observe
import com.siziksu.ui.di.USERS_VIEW_MODEL
import kotlinx.android.synthetic.main.fragment_users.frameLayout
import kotlinx.android.synthetic.main.fragment_users.progressBar
import kotlinx.android.synthetic.main.fragment_users.recyclerView
import org.koin.android.ext.android.get

class UsersFragment : Fragment() {

    private val viewModel: UsersViewModelContract by lazy { ViewModelProviders.of(this, get(USERS_VIEW_MODEL)).get(UsersViewModel::class.java) }
    private lateinit var adapter: UsersRecyclerContract.Adapter

    private var isFirstRun = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        if (isFirstRun) {
            viewModel.getUsers()
        }
        isFirstRun = false
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun initViews() {
        adapter = UsersRecyclerAdapter(activity as Context, UsersRecyclerManager())
        adapter.setOnItemClickListener { view, position ->
            view.findNavController().navigate(UsersFragmentDirections.toUserDetail(position))

        }
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter.getAdapter()
        recyclerView.layoutManager = adapter.getLayoutManager()
        observe(viewModel.usersLiveData) { users -> adapter.showItems(users) }
        observe(viewModel.errorLiveData) { message -> Snackbar.make(frameLayout, message ?: getString(R.string.error_unknown), Snackbar.LENGTH_SHORT).show() }
        observe(viewModel.progressLiveData) { value -> value?.let { if (it) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE } }
    }
}
