package com.example.focuscat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController

class ShopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val petTabBtn : Button = view.findViewById(R.id.petTab)
        val navController : NavController = view.findNavController()
        val activity : MainActivity = context as MainActivity

        val buyChickenBtn : Button = view.findViewById(R.id.buyChicken)
        val buyMilkBtn : Button = view.findViewById(R.id.buyMilk)
        val buyFishBtn : Button = view.findViewById(R.id.buyFish)


        val money : TextView = view.findViewById(R.id.displayMoney)
        money.text = "Money: $${activity.getMoney()}"

        var numOfChicken = 0
        var numOfMilk = 0
        var numOfFish = 0


        petTabBtn.setOnClickListener {
            navController.navigate(R.id.action_shopFragment_to_petFragment)
        }

        buyMilkBtn.setOnClickListener {
            if (activity.getMoney() >= 3) {
                activity.setMoney(activity.getMoney() - 3)
                money.text = "Money: $${activity.getMoney()}"
                numOfMilk++
                activity.setNumOfMilk(numOfMilk)
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }
        }

        buyChickenBtn.setOnClickListener {
            if (activity.getMoney() >= 5) {
                activity.setMoney(activity.getMoney() - 5)
                money.text = "Money: $${activity.getMoney()}"
                numOfChicken++
                activity.setNumOfChicken(numOfChicken)
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }

        }

        buyFishBtn.setOnClickListener {
            if (activity.getMoney() >= 8) {
                activity.setMoney(activity.getMoney() - 8)
                money.text = "Money: $${activity.getMoney()}"
                numOfFish++
                activity.setNumOfFish(numOfFish)
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}