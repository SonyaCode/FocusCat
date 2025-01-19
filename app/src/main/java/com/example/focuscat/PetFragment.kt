package com.example.focuscat

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController

class PetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodTabBtn : Button = view.findViewById(R.id.foodTab)
        val navController : NavController = view.findNavController()
        val activity : MainActivity = context as MainActivity

        val money : TextView = view.findViewById(R.id.displayMoney)
        money.text = "Money: $${activity.getMoney()}"

        val buyCalicoCat : Button = view.findViewById(R.id.buyCalicoCat)
        val buyBlackCat : Button = view.findViewById(R.id.buyBlackCat)
        val buyOrangeCat : Button = view.findViewById(R.id.buyOrangeCat)

        var hasCalicoCat = activity.getHasCalicoCat()
        var hasBlackCat = activity.getHasBlackCat()
        var hasOrangeCat = activity.getHasOrangeCat()


        foodTabBtn.setOnClickListener{
            navController.navigate(R.id.action_petFragment_to_shopFragment)
        }

        buyCalicoCat.setOnClickListener {
            if (activity.getMoney() >= 50 && !hasCalicoCat) {
                activity.setHasCalicoCat(true)
                activity.setMoney(activity.getMoney() - 50)
                money.text = "Money: $${activity.getMoney()}"
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }
        }

        buyBlackCat.setOnClickListener {
            if (activity.getMoney() >= 50 && !hasBlackCat) {
                activity.setHasBlackCat(true)
                activity.setMoney(activity.getMoney() - 50)
                money.text = "Money: $${activity.getMoney()}"
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }
        }

        buyOrangeCat.setOnClickListener {
            if (activity.getMoney() >= 50 && !hasOrangeCat) {
                activity.setHasOrangeCat(true)
                activity.setMoney(activity.getMoney() - 50)
                money.text = "Money: $${activity.getMoney()}"
            } else {
                Toast.makeText(getActivity(), "Not enough money!", Toast.LENGTH_SHORT).show()
            }
        }



    }
}