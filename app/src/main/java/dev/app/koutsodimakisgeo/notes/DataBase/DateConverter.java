package dev.app.koutsodimakisgeo.notes.DataBase;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static long toTimeStramp(Date date){
        return date == null ? null : date.getTime();
    }
}
