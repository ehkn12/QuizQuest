package com.example.GroupAssignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.GroupAssignment.R;

public class MainActivity extends AppCompatActivity {

    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startButton);
        startBtn.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                Intent intent = new Intent(c, QuizActivity.class);
                c.startActivity(intent);

            }
        });
    }
}
