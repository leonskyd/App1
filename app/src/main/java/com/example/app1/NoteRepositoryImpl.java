package com.example.quicknote.notes.repository;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quicknote.Constants;
import com.example.quicknote.notes.adapters.SetNoteCallback;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NoteRepositoryImpl implements NoteRepository{

    private final FirebaseFirestore firebaseStore = FirebaseFirestore.getInstance();
    private final SetNoteCallback callbacks;

    public NoteRepositoryImpl(SetNoteCallback callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public void onDeleteClicked(@NonNull String id) {
        firebaseStore
                .collection(Constants.TABLE_NAME_NOTE)
                .document(id)
                .delete();
    }

    @Override
    public void setNote(@NonNull String id, @NonNull String title, @NonNull String content) {

        final Map<String, Object> notes = new HashMap();
        notes.put("id", id);
        notes.put("title", title);
        notes.put("content", content);
        firebaseStore.collection(Constants.TABLE_NAME_NOTE)
                .document(id)
                .set(notes)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                       callbacks.onSuccessNotes("Note successfully updated");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callbacks.onErrorNotes(e.getMessage());
                    }
                });

    }
}
