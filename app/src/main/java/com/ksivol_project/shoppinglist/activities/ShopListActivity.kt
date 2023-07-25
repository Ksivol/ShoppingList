package com.ksivol_project.shoppinglist.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.ksivol_project.shoppinglist.R
import com.ksivol_project.shoppinglist.databinding.ActivityShopListBinding
import com.ksivol_project.shoppinglist.db.MainViewModel
import com.ksivol_project.shoppinglist.entities.ShopListItem
import com.ksivol_project.shoppinglist.entities.ShopListNameItem

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding
    private var shopListNameItem: ShopListNameItem? = null
    private lateinit var saveItem: MenuItem
    private var edItem: EditText? = null

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop_list_menu, menu)
        saveItem = menu?.findItem(R.id.save_item)!!
        val newItem = menu.findItem(R.id.new_item)
        edItem = newItem.actionView?.findViewById(R.id.edNewShopItem) as EditText
        newItem.setOnActionExpandListener(expandActionView())
        saveItem.isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.save_item){
            addNewShopItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNewShopItem(){
        if(edItem?.text.toString().isEmpty())return
        val item = ShopListItem(
            null,
            edItem?.text.toString(),
            null,
            0,
            shopListNameItem?.id!!,
            0
        )
        edItem?.setText("")
        mainViewModel.insertShopItem(item)
    }

    private fun expandActionView(): MenuItem.OnActionExpandListener{
        return object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(p0: MenuItem): Boolean {
                saveItem.isVisible = true
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem): Boolean {
                saveItem.isVisible = false
                invalidateOptionsMenu()
                return true
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun init(){
        shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME, ShopListNameItem::class.java) as ShopListNameItem
        // нужно исправить устаревший вариант
        binding.tvtest.text = shopListNameItem?.name
    }

    companion object{
        const val SHOP_LIST_NAME = "shop_list_name"
    }
}