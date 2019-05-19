package com.siziksu.ui.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R
import com.siziksu.ui.model.User
import kotlinx.android.synthetic.main.fragment_users.recyclerView
import org.koin.android.ext.android.get
import org.koin.core.parameter.ParameterList

class UsersFragment : Fragment(), UsersContract.View {

    private val presenter: UsersContract.Presenter<UsersContract.View>? = get { ParameterList(this) }
    private var adapter: UsersRecyclerContract.Adapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter?.getUsers()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    override fun showUsers(users: List<User>?) {
        users?.let {
            adapter?.showItems(users)
        }
    }

    override fun showError(message: String) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun initViews() {
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = UsersAdapter(activity, UsersManager())
        recyclerView.adapter = adapter?.getAdapter()
        recyclerView.layoutManager = adapter?.getLayoutManager()
    }
}
