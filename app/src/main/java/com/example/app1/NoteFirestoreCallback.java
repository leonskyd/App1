package com.example.quicknote.notes.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quicknote.noteDetails.Note;

import java.util.List;

public interface NoteFirestoreCallback {
    void onSuccessNotes(@NonNull List<Note> items);
    void onErrorNotes(@Nullable String message);
}
