package com.ksivol_project.shoppinglist.db

import androidx.room.Insert
import androidx.room.Query
import com.ksivol_project.shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Query ("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>
    @Insert
    suspend fun insertNote(note: NoteItem)
}