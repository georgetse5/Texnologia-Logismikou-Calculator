package com.example.texnologialogismikoucalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private StringBuilder currentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        currentInput = new StringBuilder();

        // Set click listeners for all the buttons
        setButtonClickListeners();
    }

    private void setButtonClickListeners() {
        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.fiveB, R.id.sixB, R.id.subtractB,
                R.id.oneB, R.id.twoB, R.id.threeB, R.id.addB, R.id.plusMinusB,
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide,
                R.id.buttonDot, R.id.buttonClear, R.id.buttonBack, R.id.buttonEquals
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick((Button) v);
                }
            });
        }
    }

    private void onButtonClick(Button button) {
        String buttonText = button.getText().toString();
        // Handle button click, update the input, and perform calculations
        // You'll need to implement this based on your calculator's logic.
    }
}
