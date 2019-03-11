package dev.app.koutsodimakisgeo.notes.DataBase;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

public abstract class AppRoomDatabase extends RoomDatabase  {
    public static final String DATABASE_NAME = "AppDatabase.db";
        private static volatile AppRoomDatabase instance;
        private static final Object LOCK = new Object();

        public abstract NoteDao noteDao();

        public static AppRoomDatabase getInstance(Context context) {
            if (instance == null) {
                synchronized (LOCK) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context.getApplicationContext(),
                                AppRoomDatabase.class, DATABASE_NAME).build();
                    }
                }
            }

            return instance;
        }
}