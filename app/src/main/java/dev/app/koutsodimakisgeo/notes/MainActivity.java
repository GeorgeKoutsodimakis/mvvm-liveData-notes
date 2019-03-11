package dev.app.koutsodimakisgeo.notes;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dev.app.koutsodimakisgeo.notes.DataBase.NoteEntity;
import dev.app.koutsodimakisgeo.notes.Ui.NoteAdapter;
import dev.app.koutsodimakisgeo.notes.Utils.SampleData;
import dev.app.koutsodimakisgeo.notes.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<NoteEntity> noteEntityList = new ArrayList<>();
    private NoteAdapter noteAdapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerView);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditorActivity.class);
                startActivity(intent);
            }
        });

        initRecyclerView();

        initViewModel();

        noteEntityList.addAll(mainViewModel.mNotes);

    }

    private void initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }


    public void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        noteAdapter = new NoteAdapter(noteEntityList, this);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_add_sample_data){
            addSampleData();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addSampleData() {
        mainViewModel.addSampleData();
    }
}
