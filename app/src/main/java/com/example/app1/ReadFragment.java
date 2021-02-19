package com.example.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReadFragment extends Fragment { // фрагмент кот открывает заметку для чтения

    TextView textView;
    Button backButton;
    Button editButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_read, container, false);
        backButton = view.findViewById(R.id.backButton);
        editButton = view.findViewById(R.id.editButton);
        textView = view.findViewById(R.id.textView);
        return view;
        // Метод, который выводит на экран все детали конструктора класса Note
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Метод где по клику на кнопки будет переход на другие фрагменты: к списку или для редактирования
    }

}

