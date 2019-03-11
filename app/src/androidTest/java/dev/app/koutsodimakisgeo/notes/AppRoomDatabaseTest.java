package dev.app.koutsodimakisgeo.notes;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dev.app.koutsodimakisgeo.notes.DataBase.AppRoomDatabase;
import dev.app.koutsodimakisgeo.notes.DataBase.NoteDao;
import dev.app.koutsodimakisgeo.notes.DataBase.NoteEntity;
import dev.app.koutsodimakisgeo.notes.Utils.SampleData;

import static org.junit.Assert.assertEquals;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */
@RunWith(AndroidJUnit4.class)
public class AppRoomDatabaseTest {
    public static final String TAG = "JUnit";
    public AppRoomDatabase roomDatabase;
    public NoteDao noteDao;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getTargetContext();
        roomDatabase = Room.inMemoryDatabaseBuilder(context, AppRoomDatabase.class).build();
        noteDao = roomDatabase.noteDao();
        Log.i(TAG, "createDb");

    }

    @After
    public void closeDb(){
        roomDatabase.close();
        Log.i(TAG,"closeDB:" );

    }

    @Test
    public void createAndGet(){
        noteDao.insertAll(SampleData.getNotes());
        int count = noteDao.getCount();
        Log.i(TAG, "count = " + count);
        assertEquals(SampleData.getNotes().size(), count);
    }

    @Test
    public void compareEntries(){
        noteDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity test = noteDao.getNoteById(1);
        assertEquals(original, test);
        assertEquals(1, test.getID());

    }




}