package com.example.quicknote.notes.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quicknote.noteDetails.Note;
import com.example.quicknote.R;
import com.google.android.material.textview.MaterialTextView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private final MaterialTextView materialTextView;
    private final NoteAdapterCallbacks callbacks;

    public NoteViewHolder(@NonNull View itemView,NoteAdapterCallbacks callbacks) {
        super(itemView);
        materialTextView = itemView.findViewById(R.id.tv_item_note);
        this.callbacks = callbacks;
    }

    public void onBind(int position, Note note) {
        materialTextView.setText(note.getName()); // сюда привозить только готовые строки без логики, без лишних полей

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onItemClicked(getAdapterPosition());
            }
        });
    }


}
