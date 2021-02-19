package com.example.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NoteFragment extends Fragment { // Фрагмент в котором создается заметка

    EditText editName; EditText editDate;
    EditText editContent; EditText editTopic;
    Button saveButton; Button delButton;
    String name; String date; String topic; String content;
    Note note;
    ArrayList<Note> blockNote = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_note, container, false);
        editName = view.findViewById(R.id.editName);
        editDate = view.findViewById(R.id.editDate);
        editTopic = view.findViewById(R.id.editTopic);
        editContent = view.findViewById(R.id.editContent);
        saveButton = view.findViewById(R.id.saveButton);
        delButton = view.findViewById(R.id.delButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSave();
        initDel();
    }


    private void initDel() {
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText(""); editDate.setText(""); editTopic.setText("");
                editContent.setText("");
            }
        });
    }

    private void initSave() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = String.valueOf(editName.getText());
                topic = String.valueOf(editTopic.getText());
                date = String.valueOf(editDate.getText());
                content = String.valueOf(editContent.getText());
                note = new Note(name, topic, date, content);
                blockNote.add(note);
            }
        });
    }
}
