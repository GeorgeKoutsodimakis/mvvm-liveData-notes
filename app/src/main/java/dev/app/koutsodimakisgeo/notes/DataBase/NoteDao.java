package dev.app.koutsodimakisgeo.notes.DataBase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */
@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> noteEntities);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("SELECT * FROM notes WHERE id = :id")
    NoteEntity selectNoteById(int id);

    @Query("SELECT * FROM notes ORDER BY data DESC")
    LiveData<List<NoteEntity>> getAllNotes();

    @Query("DELETE FROM notes")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM notes")
    int getCount();
}
