package com.siziksu.ui.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.siziksu.ui.R.layout
import com.siziksu.ui.view.model.User
import kotlinx.android.synthetic.main.fragment_main.textView
import org.koin.android.ext.android.get
import org.koin.core.parameter.ParameterList

class MainFragment : Fragment(), MainContract.View {

    private val presenter: MainContract.Presenter<MainContract.View>? = get { ParameterList(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.getUser()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    override fun showUser(user: User?) {
        user?.let {
            val text = "\n${user.name}\n${user.username}\n${user.email.toLowerCase()}\n${user.website}"
            textView.text = text
        }
    }

    override fun showError(message: String) {
        Snackbar.make(textView, message, Snackbar.LENGTH_SHORT).show()
    }
}
