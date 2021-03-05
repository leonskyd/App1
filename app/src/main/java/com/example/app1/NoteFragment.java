package com.example.quicknote;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.quicknote.Constants;
import com.example.quicknote.R;
import com.example.quicknote.notes.adapters.SetNoteCallback;
import com.example.quicknote.notes.repository.NoteRepository;
import com.example.quicknote.notes.repository.NoteRepositoryImpl;
import com.example.quicknote.notes.repository.NotesRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NoteFragment extends Fragment implements SetNoteCallback {

    private final static String ARG_MODEL_KEY = "arg_model_key";
    private String deletedId = "";
    private final NoteRepository repository = new NoteRepositoryImpl(this);

    public static Fragment newInstance(@Nullable Note note) {
        Fragment fragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_MODEL_KEY, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    private EditText titleEditText;
    private EditText contentEditText;
    private MaterialButton updateButton;
    private MaterialButton deleteButton;
    private MaterialToolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleEditText = view.findViewById(R.id.et_note_title);
        contentEditText = view.findViewById(R.id.et_note_content);
        updateButton = view.findViewById(R.id.button_update);
        deleteButton = view.findViewById(R.id.button_delete);
        toolbar = view.findViewById(R.id.toolbar_note_detail);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            }
        });
        toolbar.inflateMenu(R.menu.delete_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_note_delete) {
                    repository.onDeleteClicked(deletedId);
                }
                return false;
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String title = titleEditText.getText().toString();
                final String content = contentEditText.getText().toString();
                update(title, content);
            }
        });
        if(getArguments() != null) {
            Note note = (Note) getArguments().getSerializable(ARG_MODEL_KEY);
        if (note != null) {
            deletedId = note.getIndex();
            titleEditText.setText(note.getName());
            contentEditText.setText(note.getContent());
            }
        }
    }

    @Override
    public void onSuccessNotes (@NonNull String message){
        showToastMessage(message);
    }

    @Override
    public void onErrorNotes (@Nullable String message){
        showToastMessage(message);
    }

    private void update(
            @Nullable String title,
            @Nullable String content) {
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(content)) {
            if (getArguments() != null) {
                Note note = (Note) getArguments().getSerializable(ARG_MODEL_KEY);
                if (note != null) {
                    repository.setNote(note.getIndex(), title, content);
                } else {
                    String id = UUID.randomUUID().toString();
                    deletedId = id;
                    repository.setNote(id, title, content);
                }
            } else {
                showToastMessage(getResources().getString(R.string.empty_no));
            }
        }
    }

    private void showToastMessage(@Nullable  String message) {
        if (message != null) {
            Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show();
        }
    }
}
