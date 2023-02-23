package com.example.calculating;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;
    private Button addButton, subtractButton, multiplyButton, divideButton , dotButton ,cancelButton, equalsButton;
    private TextView resultTextView;

    private double currentNumber = 0;
    private String currentOperator = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zeroButton = findViewById(R.id.zero_button);
        oneButton = findViewById(R.id.one_button);
        twoButton = findViewById(R.id.two_button);
        threeButton = findViewById(R.id.three_button);
        fourButton = findViewById(R.id.four_button);
        fiveButton = findViewById(R.id.five_button);
        sixButton = findViewById(R.id.six_button);
        sevenButton = findViewById(R.id.seven_button);
        eightButton = findViewById(R.id.eight_button);
        nineButton = findViewById(R.id.nine_button);
        addButton = findViewById(R.id.add_button);
        subtractButton = findViewById(R.id.subtract_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divideButton = findViewById(R.id.divide_button);
        cancelButton = findViewById(R.id.cancel_button);
        equalsButton = findViewById(R.id.equals_button);
        resultTextView = findViewById(R.id.result_textview);
        dotButton = findViewById(R.id.dot_button);

        zeroButton.setOnClickListener(numberClickListener);
        oneButton.setOnClickListener(numberClickListener);
        twoButton.setOnClickListener(numberClickListener);
        threeButton.setOnClickListener(numberClickListener);
        fourButton.setOnClickListener(numberClickListener);
        fiveButton.setOnClickListener(numberClickListener);
        sixButton.setOnClickListener(numberClickListener);
        sevenButton.setOnClickListener(numberClickListener);
        eightButton.setOnClickListener(numberClickListener);
        nineButton.setOnClickListener(numberClickListener);
        dotButton.setOnClickListener(numberClickListener);

        addButton.setOnClickListener(operatorClickListener);
        subtractButton.setOnClickListener(operatorClickListener);
        multiplyButton.setOnClickListener(operatorClickListener);
        divideButton.setOnClickListener(operatorClickListener);
        cancelButton.setOnClickListener(operatorClickListener);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double newNumber = Double.parseDouble(resultTextView.getText().toString());
                double result;
                switch (currentOperator) {
                    case "+":
                        result = currentNumber + newNumber;
                        break;
                    case "-":
                        result = currentNumber - newNumber;
                        break;
                    case "*":
                        result = currentNumber * newNumber;
                        break;
                    case "/":
                        result = currentNumber / newNumber;
                        break;
                    default:
                        result = 0;
                        break;
                }
                resultTextView.setText(Double.toString(result));
            }
        });
    }

    View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();
            if (buttonText.equals(".")) {
                if (!resultTextView.getText().toString().contains(".")) {
                    resultTextView.append(buttonText);
                }
            } else {
                resultTextView.append(buttonText);
            }
        }
    };

    View.OnClickListener operatorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            currentNumber = Double.parseDouble(resultTextView.getText().toString());
            currentOperator = button.getText().toString();
            resultTextView.setText("");
        }
    };
    private void cancel() {
        resultTextView.setText("");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }
}