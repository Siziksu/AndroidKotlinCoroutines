package com.siziksu.ui.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R
import com.siziksu.ui.common.observe
import com.siziksu.ui.di.USER_VIEW_MODEL
import kotlinx.android.synthetic.main.fragment_user_detail.frameLayout
import kotlinx.android.synthetic.main.fragment_user_detail.progressBar
import kotlinx.android.synthetic.main.fragment_user_detail.userDetail
import org.koin.android.ext.android.get

class UserDetailFragment : Fragment() {

    private val viewModel: UserViewModelContract by lazy { ViewModelProviders.of(this, get(USER_VIEW_MODEL)).get(UserViewModel::class.java) }

    private var artistId: Int? = null
    private var isFirstRun = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readArguments()
        initViews()
        if (isFirstRun) {
            artistId?.let { viewModel.getUser(artistId) }
        }
        isFirstRun = false
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun readArguments() {
        val bundle = arguments
        bundle?.let {
            artistId = UserDetailFragmentArgs.fromBundle(it).userId
        }
    }

    private fun initViews() {
        observe(viewModel.userLiveData) { user ->
            user?.let {
                val userInfo = "\n${it.name}\n${it.username}\n${it.email.toLowerCase()}\n${it.website}"
                userDetail.text = userInfo
            }
        }
        observe(viewModel.errorLiveData) { message -> Snackbar.make(frameLayout, message ?: getString(R.string.error_unknown), Snackbar.LENGTH_SHORT).show() }
        observe(viewModel.progressLiveData) { value -> value?.let { if (it) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE } }
    }
}
