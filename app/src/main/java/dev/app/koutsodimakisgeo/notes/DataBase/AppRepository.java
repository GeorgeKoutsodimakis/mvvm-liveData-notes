package dev.app.koutsodimakisgeo.notes.DataBase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dev.app.koutsodimakisgeo.notes.Utils.SampleData;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

public class AppRepository {
    private static AppRepository ourInstance;
    public List<NoteEntity> mNotes;
    private AppRoomDatabase roomDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        roomDatabase = AppRoomDatabase.getInstance(context);
        mNotes = SampleData.getNotes();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                roomDatabase.noteDao().insertAll(SampleData.getNotes());
            }
        });
    }

    public void deleteNotes() {
    }
}
