package com.example.cw_7calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer fitst, seccond, sum;
    private Boolean isOperationClick = false;
    private String simvol;
    private String operation = "";
    private String result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        button=findViewById(R.id.btn_next);
        button.setOnClickListener(v -> {
            result = textView.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("key", result.toString());
            startActivity(intent);
            finish();
        });

    }

    public void onNumberClick(View view) {
        String number = ((MaterialButton) view).getText().toString();
        if (number.equals(getString(R.string.ac))) {
            button.setVisibility(View.INVISIBLE);
            textView.setText(R.string._0);
        } else if (textView.getText().toString().equals(getString(R.string._0)) || isOperationClick) {
            button.setVisibility(View.INVISIBLE);
            textView.setText(number);
        } else {
            button.setVisibility(View.INVISIBLE);
            textView.append(number);
        }

        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String operation = ((MaterialButton) view).getText().toString();
        if (operation.equals(getString(R.string._plus))){
            button.setVisibility(View.INVISIBLE);
            fitst = Integer.valueOf(textView.getText().toString());
            simvol = getString(R.string._plus);

        } else if (operation.equals(getString(R.string._minus))) {
            button.setVisibility(View.INVISIBLE);
            fitst = Integer.valueOf(textView.getText().toString());
            simvol = getString(R.string._minus);

        } else if (operation.equals(getString(R.string.umnozhenie))) {
            button.setVisibility(View.INVISIBLE);
            fitst = Integer.valueOf(textView.getText().toString());
            simvol = getString(R.string.umnozhenie);

        } else if (operation.equals(getString(R.string.delenie))) {
            button.setVisibility(View.INVISIBLE);
            fitst = Integer.valueOf(textView.getText().toString());
            simvol = getString(R.string.delenie);

        } else if (operation.equals(getString(R.string.ravno))) {
            button.setVisibility(View.VISIBLE);
            seccond = Integer.valueOf(textView.getText().toString());
            if (simvol.equals((getString(R.string._plus)))){
                sum = fitst + seccond;
                textView.setText(sum.toString());

            } else if (simvol.equals(getString(R.string._minus))) {
                sum = fitst - seccond;
                textView.setText(sum.toString());

            } else if (simvol.equals(getString(R.string.umnozhenie))) {
                sum = fitst * seccond;
                textView.setText(sum.toString());

            } else if (simvol.equals(getString(R.string.delenie))) {
                sum = fitst / seccond;
                textView.setText(sum.toString());
            }
        }


        isOperationClick = true;
    }

}