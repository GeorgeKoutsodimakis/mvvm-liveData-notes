package dev.app.koutsodimakisgeo.notes.DataBase;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

@Entity(tableName = "notes")
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private Date date;
    private String value;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Ignore

    public NoteEntity() {
    }

    public NoteEntity(int ID, Date date, String value) {
        this.ID = ID;
        this.date = date;
        this.value = value;
    }

    @Ignore
    public NoteEntity(Date date, String value) {
        this.date = date;
        this.value = value;
    }

    @Ignore
    @Override
    public String toString() {
        return "NoteEntity{" +
                "ID=" + ID +
                ", date=" + date +
                ", value='" + value + '\'' +
                '}';
    }
}


