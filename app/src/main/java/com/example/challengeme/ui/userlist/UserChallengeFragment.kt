package com.example.challengeme.ui.userlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeme.AsynchronousRequests.ChallengesAsyncTask
import com.example.challengeme.R
import com.example.challengeme.ui.Adapters.ChallengeAdapter

class UserChallengeFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var challengeAdapter: RecyclerView.Adapter<*>
    lateinit var challengeManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance() = UserChallengeFragment()
    }

    private lateinit var viewModel: UserChallengeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.user_challenge_fragment, container, false)

        // опять же, либо глобальным
        val userChallenges = ChallengesAsyncTask().execute().get()!!

        recycler = root.findViewById(R.id.userChallenges_recycler)

        challengeAdapter = ChallengeAdapter(activity!!.baseContext, userChallenges)
        challengeManager = LinearLayoutManager(activity!!.baseContext)

        recycler.apply {
            recycler.adapter = challengeAdapter
            recycler.layoutManager = challengeManager
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserChallengeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
