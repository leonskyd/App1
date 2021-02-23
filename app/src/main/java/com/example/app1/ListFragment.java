package com.example.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment { // фрагмент, где заметки можно просматривать в стопке ArrayList

    Button backButton; Button button;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_list, container, false);
        backButton = view.findViewById(R.id.backToNote);
        button = view.findViewById(R.id.button);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBack();
        toRead(); // пока чтобы попасть на третий фрагмент
        // Здесь будет метод заполнения Макета Кнопками с названием заметок
        // который отображает заполение ArrayList blockNote объектами Note

    }


    private void initBack() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new NoteFragment();
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });
    }

    private void toRead() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ReadFragment();
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });
    }


}
