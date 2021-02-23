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
    Fragment fragment;
    String content;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_read, container, false);
        backButton = view.findViewById(R.id.backToList);
        editButton = view.findViewById(R.id.editButton);
        textView = view.findViewById(R.id.textView);
        return view;
        // Метод, который выводит на экран все детали конструктора класса Note
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initBack();
        initEdit();
    }

    private void initBack() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ListFragment();
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });
    }

    private void initEdit() {
        editButton.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      /*  bundle = this.getArguments();
        content = (String) bundle.getSerializable("key");
        textView.setText(content);*/


    }

}

