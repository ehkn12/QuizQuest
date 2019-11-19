package com.example.GroupAssignment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.GroupAssignment.Fragments.InformationFragment;
import com.example.GroupAssignment.Fragments.QuizFragment;
import com.example.GroupAssignment.Fragments.ScoreboardFragment;
import com.example.GroupAssignment.Fragments.SearchRecyclerFragment;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.Activities.TestActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements SearchRecyclerFragment.OnFragmentInteractionListener {


//    Button startBtn;

    BottomNavigationView bottomNavigationView;

    Button startBtn;
    Button apiTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation_view);
        final Fragment quizFragment = new QuizFragment();
        final Fragment scoreboardFragment = new ScoreboardFragment();
        final Fragment searchFragment = new SearchRecyclerFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_quiz:
                        swapFragment(quizFragment);
                        break;
                    case R.id.navigation_scoreboard:
                        swapFragment(scoreboardFragment);
                        break;
                    case R.id.navigation_information:
                        swapFragment(searchFragment);
                        break;
                }

                return false;
            }
        });

        apiTestButton = findViewById(R.id.apiTestButton);
        apiTestButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                Intent intent = new Intent(c, TestActivity.class);
                c.startActivity(intent);

            }
        });
    }

    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}


