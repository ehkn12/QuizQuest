package com.example.GroupAssignment.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.GroupAssignment.Fragments.InformationFragment;
import com.example.GroupAssignment.Fragments.QuizFragment;
import com.example.GroupAssignment.Fragments.ScoreboardFragment;
import com.example.GroupAssignment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    BottomNavigationView bottomNavigationView;

    Button startBtn;
    Button apiTestButton;

    private Fragment quizFragment;
    private Fragment scoreboardFragment;
    private Fragment informationFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation_view);
        quizFragment = new QuizFragment();
        scoreboardFragment = new ScoreboardFragment();
        informationFragment = new InformationFragment();

        swapFragment(quizFragment);
        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_quiz:
                        swapFragment(quizFragment);
                        break;
                    case R.id.navigation_scoreboard:
                        swapFragment(scoreboardFragment);
                        break;
                    case R.id.navigation_information:
                        swapFragment(informationFragment);
                        break;

                }
                return true;
            }
        });


        apiTestButton = findViewById(R.id.apiTestButton);
        apiTestButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                Intent intent = new Intent(c, TestActivity.class);
                c.startActivity(intent);

            }
        });
    }
    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        swapFragment(scoreboardFragment);
    }
}

