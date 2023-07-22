package com.ksivol_project.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ksivol_project.shoppinglist.databinding.ActivityShopListBinding
import com.ksivol_project.shoppinglist.db.MainViewModel
import com.ksivol_project.shoppinglist.entities.ShopListNameItem

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding
    private var shopListNameItem: ShopListNameItem? = null

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME) as ShopListNameItem
        // нужно исправить устаревший вариант
        binding.tvtest.text = shopListNameItem?.name
    }

    companion object{
        const val SHOP_LIST_NAME = "shop_list_name"
    }
}