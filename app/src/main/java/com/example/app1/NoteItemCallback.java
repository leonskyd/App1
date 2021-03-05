package com.example.quicknote.notes.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.quicknote.noteDetails.Note;

public class NoteItemCallback extends DiffUtil.ItemCallback<Note> {
    @Override
    public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return oldItem.getIndex().equals(newItem.getIndex());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return oldItem.getName().equals(newItem.getName()) &&
                oldItem.getContent().equals(newItem.getContent());
    }
}
