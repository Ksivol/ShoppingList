package com.ksivol_project.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksivol_project.shoppinglist.R
import com.ksivol_project.shoppinglist.databinding.ActivityShopListBinding

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}