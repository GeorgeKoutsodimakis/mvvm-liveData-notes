package dev.app.koutsodimakisgeo.notes.Ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.app.koutsodimakisgeo.notes.DataBase.NoteEntity;
import dev.app.koutsodimakisgeo.notes.R;

/**
 * Created by koutsodimakisgeo on 11-Mar-19.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private final List<NoteEntity> noteEntityList;
    private final Context context;

    public NoteAdapter(List<NoteEntity> noteEntityList, Context context) {
        this.noteEntityList = noteEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final NoteEntity note = noteEntityList.get(position);
        holder.noteView.setText(note.getValue());
    }

    @Override
    public int getItemCount() {
        return noteEntityList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView noteView;
        public MyViewHolder(View itemView) {
            super(itemView);
            noteView = itemView.findViewById(R.id.noteView);

        }
    }
}
