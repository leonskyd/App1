package com.example.quicknote.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.quicknote.noteDetails.Note;
import com.example.quicknote.R;

public class NoteListAdapter extends ListAdapter<Note, NoteViewHolder> {

    private final NoteAdapterCallbacks callbacks;

    public NoteListAdapter(
            @NonNull DiffUtil.ItemCallback<Note> diffCallback,
            @NonNull NoteAdapterCallbacks callbacks) {
        super(diffCallback);
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view, callbacks);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.onBind(position, getItem(position));
    }
}
