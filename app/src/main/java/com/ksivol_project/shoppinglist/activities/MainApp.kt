package com.ksivol_project.shoppinglist.activities

import android.app.Application
import com.ksivol_project.shoppinglist.db.MainDataBase

class MainApp : Application () {
    val database by lazy { MainDataBase.getDataBase(this) }
}