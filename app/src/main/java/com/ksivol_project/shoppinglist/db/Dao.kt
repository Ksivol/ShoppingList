package com.ksivol_project.shoppinglist.db

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Update
import com.ksivol_project.shoppinglist.entities.NoteItem
import com.ksivol_project.shoppinglist.entities.ShoppingListName
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query ("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>
    @Query ("DELETE FROM note_list WHERE id IS :id")
    suspend fun deleteNote(id: Int)
    @Insert
    suspend fun insertNote(note: NoteItem)
    @Insert
    suspend fun insertShopListName(name: ShoppingListName)
    @Update
    suspend fun updateNote(note: NoteItem)
}