package com.example.challengeme.ui.userchallenge

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challengeme.R

class UserChallengeFragment : Fragment() {

    companion object {
        fun newInstance() = UserChallengeFragment()
    }

    private lateinit var viewModel: UserChallengeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.user_challenge_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserChallengeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
