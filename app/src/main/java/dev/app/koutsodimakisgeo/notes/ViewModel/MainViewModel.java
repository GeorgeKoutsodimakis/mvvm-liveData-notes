package dev.app.koutsodimakisgeo.notes.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import dev.app.koutsodimakisgeo.notes.DataBase.AppRepository;
import dev.app.koutsodimakisgeo.notes.DataBase.NoteEntity;
import dev.app.koutsodimakisgeo.notes.Utils.SampleData;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

public class MainViewModel extends AndroidViewModel {

    public List<NoteEntity> mNotes;
    public AppRepository appRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        appRepository = AppRepository.getInstance(application.getApplicationContext());
        mNotes = appRepository.mNotes;
    }


    public void addSampleData() {
        appRepository.addSampleData();
    }

    public void deleteNoes() {
        appRepository.deleteNotes();
    }
}
