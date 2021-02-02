package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int arg;
    final int TASK1 = 3;
    final int TASK2 = 7;
    int result1;
    int result2;
    double mod1;
    double mod2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hw);

        Button button = findViewById(R.id.button1);
        final EditText editText1 = findViewById(R.id.editText1);
        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);
        Switch switch1 = findViewById(R.id.switch1);
        Switch switch2 = findViewById(R.id.switch2);
        CheckBox checkbox = findViewById(R.id.checkbox);
        ToggleButton offButton = findViewById(R.id.offButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                arg = Integer.valueOf(editText1.getText().toString());
                    if (checkbox.isChecked() || offButton.isChecked()) {
                        switch1.setChecked(true);
                        switch2.setChecked(true);
                        doTask1(textView1);
                        doTask2(textView2);
                        return;
                    } else {
                    if (switch1.isChecked()) {
                        doTask1(textView1);
                    } else {
                        textView1.setText(" проверка на 3 отключена");
                    }
                    if (switch2.isChecked()) {
                        doTask2(textView2);
                    } else {
                        textView2.setText(" проверка на 7 отключена");
                    } }
                } catch (NumberFormatException e) {
                    textView1.setText(" Введите число ! ");
                    textView2.setText(" Введите число ! ");
                }
            }
        });
    }


    private void doTask1(TextView textView1) {
        mod1 = arg % TASK1;
        result1 = arg / TASK1;
        if (mod1 == 0) {
            textView1.setText("Результат деления на 3 - " + result1);
        } else {
            textView1.setText("Число " + arg + " не делится на " + TASK1);
        }
    }

    private void doTask2(TextView textView2) {
        mod2 = arg % TASK2;
        result2 = arg / TASK2;
        if (mod2 == 0) {
            textView2.setText("Результат деления на 7 - " + result2);
        } else {
            textView2.setText("Число " + arg + " не делится на " + TASK2);
        }
    }
}
