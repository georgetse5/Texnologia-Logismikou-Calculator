package com.example.texnologialogismikoucalculator;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
//    private StringBuilder currentInput;
//    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputText = findViewById(R.id.displayEditText);
        inputText.setShowSoftInputOnFocus(false);
//
//
//        currentInput = new StringBuilder();

//        setButtonClickListeners();

        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.inputText).equals(inputText.getText().toString())) {
                    inputText.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd) {
        String oldStr = inputText.getText().toString();

        int cursorPos = inputText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.inputText).equals(inputText.getText().toString())) {
            inputText.setText(strToAdd);
            inputText.setSelection(cursorPos + strToAdd.length());
        } else {
            inputText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            inputText.setSelection(cursorPos + strToAdd.length());
        }
    }

    public void zerosBtn(View view) {
        updateText(getResources().getString(R.string.zero));
    }

    public void oneBtn(View view) {
        updateText(getResources().getString(R.string.one));
    }

    public void twoBtn(View view) {
        updateText(getResources().getString(R.string.two));
    }

    public void threeBtn(View view) {
        updateText(getResources().getString(R.string.three));
    }

    public void fourBtn(View view) {
        updateText(getResources().getString(R.string.four));
    }

    public void fiveBtn(View view) {
        updateText(getResources().getString(R.string.five));
    }

    public void sixBtn(View view) {
        updateText(getResources().getString(R.string.six));
    }

    public void sevenBtn(View view) {
        updateText(getResources().getString(R.string.seven));
    }

    public void eightBtn(View view) {
        updateText(getResources().getString(R.string.eight));
    }

    public void nineBtn(View view) {
        updateText(getResources().getString(R.string.nine));
    }

    public void clearBtn(View view) {
        inputText.setText("");
    }

    public void equalsBtn(View view) {
        String userExp = inputText.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        inputText.setText(result);
        inputText.setSelection(result.length());

    }

    public void addBtn(View view){
        updateText(getResources().getString(R.string.add));
    }
    public void subtractBtn(View view){
        updateText(getResources().getString(R.string.subtract));
    }
    public void decimalBtn(View view) {
        updateText(getResources().getString(R.string.decimal)); }

    public void multiplyBtn(View view){
        updateText(getResources().getString(R.string.multiply));
    }

    public void parenthesisBtn(View view) {
        int cursorPos = inputText.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = inputText.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (inputText.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }
            if (inputText.getText().toString().substring(i, i + 1).equals(")")) {
                closePar += 1;
            }
        }
            if (openPar == closePar || inputText.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");
                inputText.setSelection(cursorPos + 1);
            }
            else if (closePar < openPar && !inputText.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");
        }
        inputText.setSelection(cursorPos + 1);
    }

    public void absBtn(View view){
        updateText("abs(");
    }

    public void sqrtBtn(View view){
        updateText("sqrt(");
    }

    public void sinBtn(View view){
        updateText("sin(");
    }

    public void cosBtn(View view){
        updateText("cos(");
    }
    public void tanBtn(View view) {
        updateText("tan(");
    }
    public void arctanBtn(View view){
        updateText("arctan(");
    }

    public void arcsinBtn(View view){
        updateText("arcsin(");
    }

    public void acosBtn(View view){
        updateText("acos(");
    }

    public void lnBtn(View view){
        updateText("ln(");
    }

    public void piBtn(View view){
        updateText("Pi(");
    }
    public void eBtn(View view){
        updateText("e(");
    }
    public void divideBtn(View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void logBtn(View view){
        updateText("log(");
    }
    public void xSquareBtn(View view) { updateText("^(2)"); }

    public void xPowerBtn(View view) { updateText("^("); }

    public void backspaceBtn(View view)
    {
        int cursorPos = inputText.getSelectionStart();
        int textLen = inputText.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) inputText.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            inputText.setText(selection);
            inputText.setSelection(cursorPos - 1);
        }
    }

}


