package com.example.challengeme.ui.userlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeme.AsynchronousRequests.AchievementsAsyncTask

import com.example.challengeme.R
import com.example.challengeme.ui.Adapters.AchievementAdapter

class UserAchievementFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var achievementAdapter: RecyclerView.Adapter<*>
    lateinit var achievementManager: RecyclerView.LayoutManager
    private var userId = -1

    companion object {
        fun newInstance() = UserAchievementFragment()
    }

    private lateinit var viewModel: UserAchievementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.user_achievement_fragment, container, false)
        userId = arguments!!.getInt(getText(R.string.userId).toString())

        // Или сделать глобальным
        // тогда и проще будет обработать пустой ответ
        val userAchievements = AchievementsAsyncTask(userId).execute().get()!!

        recycler = root.findViewById(R.id.userAchievements_recycler)

        achievementAdapter = AchievementAdapter(activity!!.baseContext, userAchievements)
        achievementManager = LinearLayoutManager(activity!!.baseContext)

        recycler.apply {
            recycler.adapter = achievementAdapter
            recycler.layoutManager = achievementManager
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserAchievementViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
