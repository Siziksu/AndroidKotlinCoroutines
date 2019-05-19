package com.siziksu.ui.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R
import com.siziksu.ui.model.User
import kotlinx.android.synthetic.main.fragment_user_detail.userDetail
import org.koin.android.ext.android.get
import org.koin.core.parameter.ParameterList

class UserDetailFragment : Fragment(), UserDetailContract.View {

    private var artistId: Int? = null

    private val presenter: UserDetailContract.Presenter<UserDetailContract.View>? = get { ParameterList(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readArguments()
        artistId?.let { presenter?.getUser(artistId) }
    }

    override fun showUser(user: User?) {
        user?.let {
            val userInfo = "\n${user.name}\n${user.username}\n${user.email.toLowerCase()}\n${user.website}"
            userDetail.text = userInfo
        }
    }

    override fun showError(message: String) {
        Snackbar.make(userDetail, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun readArguments() {
        artistId = arguments?.getInt(ARTIST_ID_KEY) ?: 0
    }

    companion object {

        private const val ARTIST_ID_KEY = "artistId"

        fun setArguments(artistId: Int): Bundle = Bundle().apply {
            this.putInt(ARTIST_ID_KEY, artistId)
        }
    }
}
