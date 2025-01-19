package com.example.focuscat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfig : AppBarConfiguration
    private lateinit var navController: NavController
    private var money = 0 // app-wide data
    private var hasCalicoCat = false
    private var hasBlackCat = false
    private var hasOrangeCat = false
    private var numOfChicken = 0
    private var numOfMilk = 0
    private var numOfFish = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(appBar)
        val navHostFragment : NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        val navGraph : NavGraph = navController.graph
        appBarConfig = AppBarConfiguration(navGraph)
        setupActionBarWithNavController(navController, appBarConfig)

        val prefs : SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        money = prefs.getInt("money", 0)
        numOfChicken = prefs.getInt("number of chicken", 0)
        numOfMilk = prefs.getInt("number of milk", 0)
        numOfFish = prefs.getInt("number of fish", 0)
        hasCalicoCat = prefs.getBoolean("has calico cat", false)
        hasBlackCat = prefs.getBoolean("has black cat", false)
        hasOrangeCat = prefs.getBoolean("has orange cat", false)

    }

    override fun onSupportNavigateUp(): Boolean {
        val success : Boolean = navController.navigateUp(appBarConfig)
        return success || super.onSupportNavigateUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val prefs : SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val prefEditor : SharedPreferences.Editor = prefs.edit()
        prefEditor.putInt("money", money)
        prefEditor.putInt("number of chicken", numOfChicken)
        prefEditor.putInt("number of milk", numOfMilk)
        prefEditor.putInt("number of fish", numOfFish)
        prefEditor.putBoolean("has calico cat", hasCalicoCat)
        prefEditor.putBoolean("has black cat", hasBlackCat)
        prefEditor.putBoolean("has orange cat", hasOrangeCat)

        prefEditor.apply()
    }

    // getter methods
    fun getMoney() : Int {
        return money
    }

    fun getHasCalicoCat() : Boolean {
        return hasCalicoCat
    }

    fun getHasBlackCat() : Boolean {
        return hasBlackCat
    }

    fun getHasOrangeCat() : Boolean {
        return hasOrangeCat
    }

    fun getNumOfChicken() : Int {
        return numOfChicken
    }

    fun getNumOfMilk() : Int {
        return numOfMilk
    }

    fun getNumOfFish() : Int {
        return numOfFish
    }

    // setter methods
    fun setMoney(newAmount : Int) {
        money = newAmount
    }

    // for every task the user completes, they will earn $1 or $2
    fun addMoney() {
        money += Random.nextInt(1, 3)
    }

    fun setHasCalicoCat(update : Boolean) {
        hasCalicoCat = update
    }

    fun setHasBlackCat(update : Boolean) {
        hasBlackCat = update
    }

    fun setHasOrangeCat(update : Boolean) {
        hasOrangeCat = update
    }

    fun setNumOfChicken(newNum : Int) {
        numOfChicken = newNum
    }

    fun setNumOfMilk(newNum : Int) {
        numOfMilk = newNum
    }

    fun setNumOfFish(newNum : Int) {
        numOfFish = newNum
    }


}