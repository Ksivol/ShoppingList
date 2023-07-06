package com.ksivol_project.shoppinglist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ksivol_project.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.settings -> {
                    Log.d("MyLog","Settings")
                }
                R.id.notes-> {
                    Log.d("MyLog","Notes")
                }
                R.id.shop_list -> {
                    Log.d("MyLog","List")
                }
                R.id.new_item -> {
                    Log.d("MyLog","New")
                }
            }
            true
        }
    }
}