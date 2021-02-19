package com.example.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment { // фрагмент, где заметки можно просматривать в стопке ArrayList


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_list, container, false);
        // Здесь будет метод заполнения Макета Кнопками с названием заметок
        // который отображает заполение ArrayList blockNote объектами Note

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Метод где по клику на кнопку заметки открывается сама заметка
        // Данные из активированного объекта Note из ArrayList blockNote передаются во фрагмент ReadFragment
    }

}
