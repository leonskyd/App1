package com.example.quicknote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
    private int index;
    private String name;
    private String content;
    private String date;
    private String topic;

    public Note(String name, String topic, String date, String content) {
        this.name = name;
        this.content = content;

        /*Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());*/
        this.date = date; //Format.format(currentDate);

        this.topic = topic;
        this.index = index;
    }

}
