package com.example.GroupAssignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GroupAssignment.AsyncTask.AsyncTaskDelegate;
import com.example.GroupAssignment.AsyncTask.QuestionInsertAsyncTask;
import com.example.GroupAssignment.QuestionDatabase;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private QuizActivity quizActivity;


    TextView scoreText;
    TextView questionText;
    RadioButton optionA;
    RadioButton optionB;
    RadioButton optionC;
    Button nextBtn;

    QuestionDatabase db;

    int score = 0;
    int questionNum = 0;
    Question currentQuestion;

    public static ArrayList<Integer> scoreHistoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        LinearLayout quizLinearLayout = findViewById(R.id.quizLinearLayout);
        db = QuestionDatabase.getInstance(quizLinearLayout.getContext());

        questionText = quizLinearLayout.findViewById(R.id.quizQuestion);
        scoreText = quizLinearLayout.findViewById(R.id.scoreText);
        optionA = quizLinearLayout.findViewById(R.id.quizOptionA);
        optionB = quizLinearLayout.findViewById(R.id.quizOptionB);
        optionC = quizLinearLayout.findViewById(R.id.quizOptionC);
        nextBtn = quizLinearLayout.findViewById(R.id.quizNextButton);

        Intent intent = getIntent();


        //TODO: After everything else is done, we can convert the QuestionDB stuff into the AsyncTaskDelegates etc
        // Don't uncomment this just yet, the entire part below will have to change but im not sure yet how so
/*      QuestionInsertAsyncTask questionInsertAsyncTask = new QuestionInsertAsyncTask();
        questionInsertAsyncTask.setQuestionDatabase(db);
        questionInsertAsyncTask.setDelegate((AsyncTaskDelegate) quizActivity);
        questionInsertAsyncTask.execute(getQuestionList());*/


        db.questionDao().insertAll(getQuestionList());

        currentQuestion = db.questionDao().getQuestion(questionNum);
        setQuestion(currentQuestion, score);

        nextBtn.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.quizOptions);
                RadioButton answer = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                if (currentQuestion.getAnswer().equals(answer.getText())){
                    score++;
                } else {
                    //TODO: display api?
                }
                answer.setChecked(false);
                Toast.makeText(getApplicationContext(), Integer.toString(questionNum), Toast.LENGTH_LONG).show();

                // Below code is to make sure that the button text changes to finish quiz on final question, and to
                // record the final score in an ArrayList
                if (questionNum < getQuestionList().size() - 2) {
                    questionNum++;
                    currentQuestion = db.questionDao().getQuestion(questionNum);

                    setQuestion(currentQuestion, score);
                }
                else if (questionNum == getQuestionList().size() - 2) {
                    questionNum++;
                    currentQuestion = db.questionDao().getQuestion(questionNum);

                    setQuestion(currentQuestion, score);
                    Toast.makeText(getApplicationContext(), "HooooooooHOo", Toast.LENGTH_LONG).show();

                    nextBtn.setText("Finish Quiz");
                }
                else {
                    scoreHistoryList.add(score);
                    //Toast to check for score at the end
                    Toast.makeText(getApplicationContext(), Integer.toString(score), Toast.LENGTH_LONG).show();
                    //TODO: Maybe have code here that does something after user finishes quiz (not decided yet)
                    // either changing to another fragment or whatever

                    //TODO Right now after pressing the last button (Finish Quiz) it just returns to the original activity
                    // We're probably putting all these into fragments right, make sure it doesnt happen again during fragments
                }


            }
        });






    }

    public void setQuestion(Question question, int score){

        scoreText.setText("Score: " + score);
        questionText.setText(question.getQuestion());
        optionA.setText(question.getOptionA());
        optionB.setText(question.getOptionB());
        optionC.setText(question.getOptionC());
    }

    public List<Question> getQuestionList(){
        //TODO:: to put this somewhere that's not here
        //TODO:: add url from api, not sure we can find relevant data in our APIs for these questions
        //questions and answers from https://www.sageadvice.eu/2017/11/27/trivia-quiz-on-5th-edition-dd-rules/
        List<Question> questionList = new ArrayList<>();
        questionList.add(0, new Question(0,
                "Can you cast underwater?",
                "No",
                "Yes, but fire spells deal no damage.",
                "Yes",
                "Yes",
                ""));
        questionList.add(1, new Question(1,
                "Is there alignment restriction for classes in Player's Handbook?",
                "Yes, Paladin must be Lawful Good, Druid must be Neutral and Assassin must be evil.",
                "No",
                "Yes, Paladin must be Good and Monk Lawful.",
                "No",
                ""));
        questionList.add(2, new Question(2,
                "Can you knock a creature out with a melee spell attack?",
                "Only with Spell Sniper feat.",
                "No, only with a melee weapon.",
                "Yes",
                "Yes",
                ""));
        questionList.add(3, new Question(3,
                "Can you use a shield with Mage Armor spell?",
                "Only with a light shield or buckler shield.",
                "Yes, Mage Armor spell works with a shield",
                "Nope, they do not stack.",
                "Yes, Mage Armor spell works with a shield.",
                ""));
        questionList.add(4, new Question(4,
                "A monster is immune to damage from nonmagical bludgeoning weapons. Does he still take damage from falling?",
                "Yes, but has resistance to damage.",
                "No, fall is a bludgeoning damage.",
                "Yes, fall is not a weapon.",
                "Yes, fall is not a weapon.",
                ""));
        questionList.add(5, new Question(5,
                "If a 5th level wizard casts a Fireball during surprise, do the enemies get disadvantage on their saving throw?",
                "No",
                "Only if wizard has with War Caster feat.",
                "Yes",
                "No",
                ""));
        questionList.add(6, new Question(6,
                "Is a 1 on an ability check an automatic failure?",
                "No",
                "Yes.",
                "Yes and roll a d10 on Fumble table.",
                "No",
                ""));
        questionList.add(7, new Question(7,
                "Can rogue get sneak attack damage against undead?",
                "Yes, Sneak Attack works against Undead.",
                "No, undeads have resistance to sneak attack.",
                "Only if you use a bludgeoning weapon.",
                "Yes, Sneak Attack works against Undead.",
                ""));
        questionList.add(8, new Question(8,
                "If you have a creature between you and the target...",
                "Target has cover +4 bonus to AC.",
                "Target has half-cover +2 bonus to AC.",
                "You have disadvantage.",
                "Target has half-cover +2 bonus to AC.",
                ""));
        questionList.add(9, new Question(9,
                "Can you make an attack action from Prone condition?",
                "Yes, but you have disadvantage on attack rolls.",
                "No, you must stand up (half movement) and attack.",
                "Only with a weapon with reach property.",
                "Yes, but you have disadvantage on attack rolls.",
                ""));

        return questionList;
    }

    public static ArrayList<Integer> getScoreHistory() {
        return scoreHistoryList;
    }




}
