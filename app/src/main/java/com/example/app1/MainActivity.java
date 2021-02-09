package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Integer a;
    Integer b;
    Integer result;
    String action;
    String numb;
    EditText tableau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_grid);

        tableau = findViewById(R.id.editText);

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        Button plus = findViewById(R.id.button_plus);
        plus.setOnClickListener(this);
        Button minus = findViewById(R.id.button_minus);
        minus.setOnClickListener(this);
        Button multiply = findViewById(R.id.button_mult);
        multiply.setOnClickListener(this);
        Button divide = findViewById(R.id.button_divide);
        divide.setOnClickListener(this);
        Button zero = findViewById(R.id.button_zero);
        zero.setOnClickListener(this);
        Button point = findViewById(R.id.button_point);
        point.setOnClickListener(this);
        Button delete = findViewById(R.id.button_delete);
        delete.setOnClickListener(this);


        Button result = findViewById(R.id.button_result);
        result.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    b = parseInt(String.valueOf(tableau.getText()));
                    if (action == "sum") {
                        tableau.setText (a + b);
                    }
                    if (action == "prod") {
                        tableau.setText (a * b);
                    }
                    if (action == "diff") {
                        tableau.setText (a - b);
                    }
                    if (action == "quot") {
                        tableau.setText (a /b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    tableau.setText (" Not done ");
                } finally { tableau.setText (" error !");
                }
            }
        });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_1:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "1");
                break;
            case R.id.button_2:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "2");
                break;
            case R.id.button_3:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "3");
                break;
            case R.id.button_4:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "4");
                break;
            case R.id.button_5:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "5");
                break;
            case R.id.button_6:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "6");
                break;
            case R.id.button_7:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "7");
                break;
            case R.id.button_8:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "8");
                break;
            case R.id.button_9:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "9");
                break;
            case R.id.button_zero:
                numb = String.valueOf(tableau.getText());
                tableau.setText(numb + "0");
                break;
            case R.id.button_plus:
                a = Integer.parseInt(tableau.getText().toString());
                action = "sum";
                tableau.setText(" ");
                break;
            case R.id.button_minus:
                a = parseInt(String.valueOf(tableau.getText()));
                action = "diff";
                tableau.setText(" ");
                break;
            case R.id.button_mult:
                a = parseInt(String.valueOf(tableau.getText()));
                action = "prod";
                tableau.setText(" ");
                break;
            case R.id.button_divide:
                a = parseInt(String.valueOf(tableau.getText()));
                action = "quot";
                tableau.setText(" ");
                break;
            case R.id.button_delete:
                tableau.setText(" ");
                break;
        }
    }
}
