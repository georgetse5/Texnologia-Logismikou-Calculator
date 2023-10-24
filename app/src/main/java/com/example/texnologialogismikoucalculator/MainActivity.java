package com.example.texnologialogismikoucalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

    }
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + strToAdd.length());
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + strToAdd.length());
        }
    }
    public void zerosBtn(View view){
        updateText(getResources().getString(R.string.zero));
    }

    public void oneBtn(View view){
        updateText(getResources().getString(R.string.one));
    }

    public void twoBtn(View view){
        updateText(getResources().getString(R.string.two));
    }

    public void threeBtn(View view){
        updateText(getResources().getString(R.string.three));
    }

    public void fourBtn(View view){
        updateText(getResources().getString(R.string.four));
    }

    public void fiveBtn(View view){
        updateText(getResources().getString(R.string.five));
    }

    public void sixBtn(View view){
        updateText(getResources().getString(R.string.six));
    }

    public void sevenBtn(View view){
        updateText(getResources().getString(R.string.seven));
    }

    public void eightBtn(View view){
        updateText(getResources().getString(R.string.eight));
    }

    public void nineBtn(View view){
        updateText(getResources().getString(R.string.nine));
    }

    public void clearBtn(View view){
        display.setText("");
    }
    public void equalsBtn(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
}

