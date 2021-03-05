package com.example.quicknote.notes.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public interface SetNoteCallback {
    void onSuccessNotes(@NonNull String message);
    void onErrorNotes(@Nullable String message);
}
