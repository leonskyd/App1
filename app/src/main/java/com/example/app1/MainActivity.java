package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /* 1. make class Note, constructor has name, content, date, topic,
       2. make fragment for Note output
       3. implement fragment into Activity
       4. Make second fragment where Note.content is shown
       5. Make land-realization
    *
    * */
 Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new NoteFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, fragment);
        ft.commit();
    }


}
