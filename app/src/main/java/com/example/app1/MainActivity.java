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
    String action;
    String numb;
    EditText editText;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_grid);
        
        setDayNight();
        
        calculator = new Calculator();
        editText = findViewById(R.id.editText);

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
                    b = parseInt(String.valueOf(editText.getText()));
                    int result = calculator.Count(a,b,action);
                    editText.setText(String.valueOf(result));
            }
        });
    }

      private void setDayNight() {
        Switch switch1 = findViewById(R.id.dayNight);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_1:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "1");
                break;
            case R.id.button_2:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "2");
                break;
            case R.id.button_3:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "3");
                break;
            case R.id.button_4:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "4");
                break;
            case R.id.button_5:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "5");
                break;
            case R.id.button_6:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "6");
                break;
            case R.id.button_7:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "7");
                break;
            case R.id.button_8:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "8");
                break;
            case R.id.button_9:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "9");
                break;
            case R.id.button_zero:
                numb = String.valueOf(editText.getText());
                editText.setText(numb + "0");
                break;
            case R.id.button_plus:
                a = Integer.parseInt(editText.getText().toString());
                action = "sum";
                editText.setText("");
                break;
            case R.id.button_minus:
                a = parseInt(String.valueOf(editText.getText()));
                action = "diff";
                editText.setText("");
                break;
            case R.id.button_mult:
                a = parseInt(String.valueOf(editText.getText()));
                action = "prod";
                editText.setText("");
                break;
            case R.id.button_divide:
                a = parseInt(String.valueOf(editText.getText()));
                action = "quot";
                editText.setText("");
                break;
            case R.id.button_delete:
                editText.setText("");
                break;
        }
    }
}
