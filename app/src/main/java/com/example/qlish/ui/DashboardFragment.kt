package com.example.qlish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.qlish.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        //call onClickListeners
        setupTakeATestClickListener(navController)
        setupTestHistoryClickListener(navController)
        setupDailyWordClickListener(navController)
        setupDailyTaskClickListener(navController)
        setupDailyTipsClickListener(navController)
        setupDailyTipsClickListener(navController)
        setupProgressOverviewClickListener(navController)

    }

    private fun setupTakeATestClickListener(navController: NavController) {
        val card = binding.takeATestCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToTakeATest()
            navController.navigate(action)
        }
    }

    private fun setupTestHistoryClickListener(navController: NavController){
        val card = binding.testHistoryCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToTestHistoryFragment()
            navController.navigate(action)
        }
    }

    private fun setupDailyWordClickListener(navController: NavController){
        val card = binding.wordOfTheDayCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToWordOfTheDayFragment()
            navController.navigate(action)
        }
    }

    private fun setupDailyTaskClickListener(navController: NavController){
        val card = binding.dailyTasksCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDailyTasksFragment()
            navController.navigate(action)
        }
    }

    private fun setupDailyTipsClickListener(navController: NavController){
        val card = binding.dailyTipsCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDailyTipsFragment()
            navController.navigate(action)
        }
    }


    private fun setupProgressOverviewClickListener(navController: NavController){
        val card = binding.progressOverviewCard
        card.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToProgressOverviewFragment()
            navController.navigate(action)
        }
    }


}