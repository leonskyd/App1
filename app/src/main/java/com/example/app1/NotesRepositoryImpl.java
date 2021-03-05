package com.example.quicknote.notes.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.quicknote.Constants;
import com.example.quicknote.noteDetails.Note;
import com.example.quicknote.notes.adapters.NoteFirestoreCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    private final FirebaseFirestore firebaseStore = FirebaseFirestore.getInstance();
    private final NoteFirestoreCallback callbacks;

    public NotesRepositoryImpl(NoteFirestoreCallback callbacks) {
        this.callbacks = callbacks;
    }


    @Override
    public void requestNotes() {
        firebaseStore.collection(Constants.TABLE_NAME_NOTE)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.getResult() != null) {
                            List<Note> items = task.getResult().toObjects(Note.class);
                            callbacks.onSuccessNotes(items);
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callbacks.onErrorNotes(e.getMessage());
                    }
                });
    }

    @Override
    public void onDeleteClicked(@NonNull String id) {
        firebaseStore
                .collection(Constants.TABLE_NAME_NOTE)
                .document(id)
                .delete();
    }
}