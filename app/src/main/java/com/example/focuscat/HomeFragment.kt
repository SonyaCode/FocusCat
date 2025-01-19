package com.example.focuscat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tasksBtn : Button = view.findViewById(R.id.tasks)
        val shopBtn : Button = view.findViewById(R.id.shop)
        val money : TextView = view.findViewById(R.id.displayMoney)

        val navController : NavController = view.findNavController()
        val activity : MainActivity = context as MainActivity
        money.text = "Money: $${activity.getMoney()}"

        val grayAndWhiteCat : ImageView = view.findViewById(R.id.grayWhiteCat)
        val calicoCat : ImageView = view.findViewById(R.id.calicoCat)
        val blackCat : ImageView = view.findViewById(R.id.blackCat)
        val orangeCat : ImageView = view.findViewById(R.id.orangeCat)
        val cats = listOf(calicoCat, blackCat, orangeCat)

        val hasCalicoCat = activity.getHasCalicoCat()
        val hasBlackCat = activity.getHasBlackCat()
        val hasOrangeoCat = activity.getHasOrangeCat()
        val hasCatsList = listOf(hasCalicoCat, hasBlackCat, hasOrangeoCat)

        val feedChicken : ImageButton = view.findViewById(R.id.feedChicken)
        val feedMilk : ImageButton = view.findViewById(R.id.feedMilk)
        val feedFish : ImageButton = view.findViewById(R.id.feedFish)

        val numOfChicken : TextView = view.findViewById(R.id.numOfChicken)
        val numOfMilk : TextView = view.findViewById(R.id.numOfMilk)
        val numOfFish : TextView = view.findViewById(R.id.numOfFish)

        numOfChicken.text = activity.getNumOfChicken().toString()
        numOfMilk.text = activity.getNumOfMilk().toString()
        numOfFish.text = activity.getNumOfFish().toString()

        for (i in cats.indices) {
            if (!hasCatsList[i]) {
                cats[i].visibility = View.INVISIBLE
            }
        }


        tasksBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_tasksFragment)
        }

        shopBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_shopFragment)
        }

        feedChicken.setOnClickListener {
            if (activity.getNumOfChicken() >= 1) {
                activity.setNumOfChicken(activity.getNumOfChicken() - 1)
            } else {
                Toast.makeText(getActivity(), "Not enough chicken!", Toast.LENGTH_SHORT).show()
            }
            numOfChicken.text = activity.getNumOfChicken().toString()
        }

        feedMilk.setOnClickListener {
            if (activity.getNumOfMilk() >= 1) {
                activity.setNumOfMilk(activity.getNumOfMilk() - 1)
            } else {
                Toast.makeText(getActivity(), "Not enough milk!", Toast.LENGTH_SHORT).show()
            }
            numOfMilk.text = activity.getNumOfMilk().toString()
        }

        feedFish.setOnClickListener {
            if (activity.getNumOfFish() >= 1) {
                activity.setNumOfFish(activity.getNumOfFish() - 1)
            } else {
                Toast.makeText(getActivity(), "Not enough fish!", Toast.LENGTH_SHORT).show()
            }
            numOfFish.text = activity.getNumOfFish().toString()
        }

    }
}