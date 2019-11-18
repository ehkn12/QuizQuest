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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.GroupAssignment.Fragments.InformationFragment;
import com.example.GroupAssignment.Fragments.QuizFragment;
import com.example.GroupAssignment.Fragments.ScoreboardFragment;
import com.example.GroupAssignment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  edits-alison
//    Button startBtn;

    BottomNavigationView bottomNavigationView;

=======
    Button startBtn;
    Button apiTestButton;
  master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navigation_quiz) {
                    Fragment fragment = new QuizFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navigation_scoreboard) {
                    Fragment fragment = new ScoreboardFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navigation_information) {
                    Fragment fragment = new InformationFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
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
}



//        startBtn = findViewById(R.id.startButton);
//        startBtn.setOnClickListener( new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Context c = view.getContext();
//
//                Intent intent = new Intent(c, QuizActivity.class);
//                c.startActivity(intent);
//
//            }
//        });
