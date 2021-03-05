package com.example.quicknote.notes.repository;

import androidx.annotation.NonNull;

public interface NotesRepository {
    void requestNotes();

    void onDeleteClicked(@NonNull String id);
}
