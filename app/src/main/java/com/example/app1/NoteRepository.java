package com.example.quicknote.notes.repository;

import androidx.annotation.NonNull;

public interface NoteRepository {
    void setNote(
            @NonNull String id,
            @NonNull String title,
            @NonNull String content);

    void onDeleteClicked(@NonNull String id);

}
