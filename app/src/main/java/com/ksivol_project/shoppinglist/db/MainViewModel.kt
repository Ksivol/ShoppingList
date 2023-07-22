package com.ksivol_project.shoppinglist.db

import androidx.lifecycle.*
import com.ksivol_project.shoppinglist.entities.NoteItem
import com.ksivol_project.shoppinglist.entities.ShopListNameItem
import kotlinx.coroutines.launch

class MainViewModel(dataBase: MainDataBase) : ViewModel() {
    val dao = dataBase.getDao()

    val allNotes: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()
    val allShopListNames: LiveData<List<ShopListNameItem>> = dao.getAllShopListNames().asLiveData()
    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }

    fun insertShopListName(listName: ShopListNameItem) = viewModelScope.launch {
        dao.insertShopListName(listName)
    }

    fun updateNote(note: NoteItem) = viewModelScope.launch {
        dao.updateNote(note)
    }

    fun updateListName(shopListName: ShopListNameItem) = viewModelScope.launch {
        dao.updateListName(shopListName)
    }

    fun deleteNote(id: Int) = viewModelScope.launch {
        dao.deleteNote(id)
    }

    fun deleteShopListName(id: Int) = viewModelScope.launch {
        dao.deleteShopListName(id)
    }

    class MainViewModelFactory(val database: MainDataBase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw java.lang.IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}