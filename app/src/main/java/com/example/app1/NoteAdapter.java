package com.example.quicknote.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quicknote.noteDetails.Note;
import com.example.quicknote.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder>{

    private final List<Note> notes = new ArrayList<>();
    private final NoteAdapterCallbacks callbacks;

    public NoteAdapter(NoteAdapterCallbacks callbacks) {
        this.callbacks = callbacks;
    }


    public void setItems(List<Note> noteList) {
        notes.clear();
        notes.addAll(noteList);
        notifyDataSetChanged(); // плох тем что обновит все пункты
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view, callbacks);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.onBind(position, notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
