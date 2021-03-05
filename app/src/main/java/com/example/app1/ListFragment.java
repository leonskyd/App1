package com.example.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quicknote.Note;
import com.example.quicknote.NoteFragment;
import com.example.quicknote.NoteAdapterCallbacks;
import com.example.quicknote.NoteFirestoreCallback;
import com.example.quicknote.NoteItemCallback;
import com.example.quicknote.NoteListAdapter;
import com.example.quicknote.NoteSpaceDecorator;
import com.example.quicknote.R;

import com.example.quicknote.notes.repository.NotesRepository;
import com.example.quicknote.notes.repository.NotesRepositoryImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements NoteAdapterCallbacks, NoteFirestoreCallback {

    private RecyclerView recyclerView;
    private FloatingActionButton fb;
    private final List<Note> blockNote = new ArrayList<>();
    private final NotesRepository repository = new NotesRepositoryImpl(this);
    private final NoteListAdapter noteListAdapter = new NoteListAdapter(new NoteItemCallback(), this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_new, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_notes);
        fb = view.findViewById(R.id.fb_notes_add);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.addItemDecoration(new NoteSpaceDecorator(getResources().getDimensionPixelSize(R.dimen.default_space)));
        recyclerView.setAdapter(noteListAdapter);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(null);
            }
        });
        repository.requestNotes();
    }

    @Override
    public void onItemClicked(int position) {
        Note note = blockNote.get(position);
        replaceFragment(note);
    }

    @Override
    public void onLongItemClicked(int position) {
        Note note = blockNote.get(position);
        repository.onDeleteClicked(note.getIndex());
    }


    private void replaceFragment(@Nullable Note note) {
        Fragment fragment = NoteFragment.newInstance(note);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onSuccessNotes(@NonNull List<Note> items) {
        blockNote.clear();
        blockNote.addAll(items);
        noteListAdapter.submitList(items);
    }

    @Override
    public void onErrorNotes(@Nullable String message) {
        showToast(message);
    }

    private void showToast(@Nullable String message) {
        if (message != null) {
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
