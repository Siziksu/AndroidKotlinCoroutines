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
import kotlinx.android.synthetic.main.fragment_user_detail.frameLayout
import kotlinx.android.synthetic.main.fragment_user_detail.progressBar
import kotlinx.android.synthetic.main.fragment_user_detail.userDetail
import org.koin.android.ext.android.get

class UserDetailFragment : Fragment() {

    private var artistId: Int? = null

    private var viewModelProvider: UserViewModelProvider = get()
    private val viewModel: UserViewModelContract by lazy { ViewModelProviders.of(this, viewModelProvider).get(UserViewModel::class.java) }

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
        artistId = arguments?.getInt(ARTIST_ID_KEY) ?: 0
    }

    private fun initViews() {
        observe(viewModel.userLiveData) { user ->
            user?.let {
                val userInfo = "\n${user.name}\n${user.username}\n${user.email.toLowerCase()}\n${user.website}"
                userDetail.text = userInfo
            }
        }
        observe(viewModel.errorLiveData) { message -> Snackbar.make(frameLayout, message ?: "Error: Unknown error.", Snackbar.LENGTH_SHORT).show() }
        observe(viewModel.progressLiveData) { value -> value?.let { if (value) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE } }
    }

    companion object {

        private const val ARTIST_ID_KEY = "artistId"

        fun setArguments(artistId: Int): Bundle = Bundle().apply {
            this.putInt(ARTIST_ID_KEY, artistId)
        }
    }
}
