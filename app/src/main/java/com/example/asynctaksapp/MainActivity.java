package com.example.asynctaksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* Variaveis */
    private Button btnStart;
    private TextView txtResultViewNumber;
    private TextView txtFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Vinculando variaveis locais aos seus devidos imputs */
        btnStart = findViewById(R.id.btnStart);
        txtResultViewNumber = findViewById(R.id.txtResultViewNumber);
        txtFeedBack = findViewById(R.id.txtFeedBack);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ShowResults results = new ShowResults(btnStart, txtResultViewNumber, txtFeedBack);
        results.execute(12);
    }
}