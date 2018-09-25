package com.example.android.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {
    private boolean choosedA1;
    private boolean choosedB1;
    private boolean choosedC1;
    private boolean choosedD1;
    private boolean choosedA2;
    private boolean choosedB2;
    private boolean choosedC2;
    private boolean choosedD2;
    private boolean choosedA3;
    private boolean choosedB3;
    private boolean choosedC3;
    private boolean choosedD3;
    private boolean choosedA4;
    private boolean choosedB4;
    private boolean choosedC4;
    private boolean choosedD4;
    private boolean choosedA5;
    private boolean choosedB5;
    private boolean choosedC5;
    private boolean choosedD5;
    private boolean choosedA7;
    private boolean choosedB7;
    private boolean choosedC7;
    private boolean choosedD7;
    private int score = 0;//Stores score value
    private int unAnswered = 0;// Stores value of how many questions are unAnswered.
    private String answerOf6;
    @BindView(R.id.a1) RadioButton optionA1;
    @BindView(R.id.b1) RadioButton optionB1;
    @BindView(R.id.c1) RadioButton optionC1;
    @BindView(R.id.d1) RadioButton optionD1;
    @BindView(R.id.a2) RadioButton optionA2;
    @BindView(R.id.b2) RadioButton optionB2;
    @BindView(R.id.c2) RadioButton optionC2;
    @BindView(R.id.d2) RadioButton optionD2;
    @BindView(R.id.a3) RadioButton optionA3;
    @BindView(R.id.b3) RadioButton optionB3;
    @BindView(R.id.c3) RadioButton optionC3;
    @BindView(R.id.d3) RadioButton optionD3;
    @BindView(R.id.a4) CheckBox optionA4;
    @BindView(R.id.b4) CheckBox optionB4;
    @BindView(R.id.c4) CheckBox optionC4;
    @BindView(R.id.d4) CheckBox optionD4;
    @BindView(R.id.a5) RadioButton optionA5;
    @BindView(R.id.b5) RadioButton optionB5;
    @BindView(R.id.c5) RadioButton optionC5;
    @BindView(R.id.d5) RadioButton optionD5;
    @BindView(R.id.answer_of_6) EditText userAnswer;
    @BindView(R.id.a7) RadioButton optionA7;
    @BindView(R.id.b7) RadioButton optionB7;
    @BindView(R.id.c7) RadioButton optionC7;
    @BindView(R.id.d7) RadioButton optionD7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //below code executes when Submit button pressed.
        Button submitButton = findViewById(R.id.submit_result);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = 0;
                unAnswered = 0;
                /*
                Question 1
                Answer is B
                */

                //Checking every option so that I can check if user selected at-least one option
                choosedA1 = optionA1.isChecked();
                choosedB1 = optionB1.isChecked();
                choosedC1 = optionC1.isChecked();
                choosedD1 = optionD1.isChecked();
                if (optionB1.isChecked()) {
                    score++;
                }

                //if No option is checked, Unanswered will increment by one. UnAnswered should be 0 to submit test.
                if (!optionA1.isChecked() && !optionB1.isChecked() && !optionC1.isChecked() && !optionD1.isChecked()) {
                    unAnswered++;
                }

                /*
                Question 2
                Answer is C
                */
                choosedA2 = optionA2.isChecked();
                choosedB2 = optionB2.isChecked();
                choosedC2 = optionC2.isChecked();
                choosedD2 = optionD2.isChecked();
                if (optionC2.isChecked()) {
                    score++;
                }

                if (!optionA2.isChecked() && !optionB2.isChecked() && !optionC2.isChecked() && !optionD2.isChecked()) {
                    unAnswered++;
                }
                /*
                Question 3
                Answer is D
                */
                choosedA3 = optionA3.isChecked();
                choosedB3 = optionB3.isChecked();
                choosedC3 = optionC3.isChecked();
                choosedD3 = optionD3.isChecked();
                if (optionD3.isChecked()) {
                    score++;
                }
                if (!optionA3.isChecked() && !optionB3.isChecked() && !optionC3.isChecked() && !optionD3.isChecked()) {
                    unAnswered++;
                }
                /*
                Question 4
                Answer is A and B and C
                */
                choosedA4 = optionA4.isChecked();
                choosedB4 = optionB4.isChecked();
                choosedC4 = optionC4.isChecked();
                choosedD4 = optionD4.isChecked();

                //A, B and C needs to be checked for correct answer
                if (optionA4.isChecked() && optionB4.isChecked() && optionC4.isChecked()) {
                    if (!optionD4.isChecked()) {
                        score++;
                    }
                }
                if (!optionA4.isChecked() && !optionB4.isChecked() && !optionC4.isChecked() && !optionD4.isChecked()) {
                    unAnswered++;
                }
                /*
                Questions 5
                Answer is B
                */
                choosedA5 = optionA5.isChecked();
                choosedB5 = optionB5.isChecked();
                choosedC5 = optionC5.isChecked();
                choosedD5 = optionD5.isChecked();
                if (optionB5.isChecked()) {
                    score++;
                }
                if (!optionA5.isChecked() && !optionB5.isChecked() && !optionC5.isChecked() && !optionD5.isChecked()) {
                    unAnswered++;
                }
                /*
                Questions 6
                Answer is Charles Babbage
                */
                answerOf6 = userAnswer.getText().toString();
                //checks if userAnswer is answered or not.
                int sizeOfText = answerOf6.length();
                if (sizeOfText == 0) {
                    unAnswered++;
                }
                //User can give answer in all caps or with double space or partial name. So, used below idea to be accepted as correct answer in different cases.
                answerOf6 = answerOf6.toLowerCase();
                answerOf6 = answerOf6.replace(" ", "");
                switch (answerOf6) {
                    case "charlesbabbage":
                        score++;
                        break;
                    case "charles":
                        score++;
                        break;
                    case "babbage":
                        score++;
                        break;
                }

                /*
                Questions 7
                Answer is D
                */
                choosedA7 = optionA7.isChecked();
                choosedB7 = optionB7.isChecked();
                choosedC7 = optionC7.isChecked();
                choosedD7 = optionD7.isChecked();
                if (optionD7.isChecked()) {
                    score++;
                }
                if (!optionA7.isChecked() && !optionB7.isChecked() && !optionC7.isChecked() && !optionD7.isChecked()) {
                    unAnswered++;
                }
                if (unAnswered != 0) {
                    Toast.makeText(getApplicationContext(), "Please Answer all questions", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //displayResult is a Toast message
                    displayResult(score);
                }

                //Alert dialog is to show result and to show correct answers and also, user can restart quiz
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("You got " + score + "/7 Marks");
                builder.setMessage("Do you want to see results ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Here are the results", Toast.LENGTH_SHORT).show();
                        //If user clicks 'YES' below code replaces options' text with below strings with correct or wrong icon.
                        String TextA1 = getString(R.string.option1A) + " ❌";
                        TextView A1 = findViewById(R.id.a1);
                        A1.setText(TextA1);

                        String TextB1 = getString(R.string.option1B) + " ✔️";
                        TextView B1 = findViewById(R.id.b1);
                        B1.setText(TextB1);

                        String TextC1 = getString(R.string.option1C) + " ❌";
                        TextView C1 = findViewById(R.id.c1);
                        C1.setText(TextC1);

                        String TextD1 = getString(R.string.option1D) + " ❌";
                        TextView D1 = findViewById(R.id.d1);
                        D1.setText(TextD1);

                        String TextA2 = getString(R.string.option2A) + " ❌";
                        TextView A2 = findViewById(R.id.a2);
                        A2.setText(TextA2);

                        String TextB2 = getString(R.string.option2B) + " ❌";
                        TextView B2 = findViewById(R.id.b2);
                        B2.setText(TextB2);

                        String TextC2 = getString(R.string.option2C) + " ✔️";
                        TextView C2 = findViewById(R.id.c2);
                        C2.setText(TextC2);

                        String TextD2 = getString(R.string.option2D) + " ❌";
                        TextView D2 = findViewById(R.id.d2);
                        D2.setText(TextD2);

                        String TextA3 = getString(R.string.option3A) + " ❌";
                        TextView A3 = findViewById(R.id.a3);
                        A3.setText(TextA3);

                        String TextB3 = getString(R.string.option3B) + " ❌";
                        TextView B3 = findViewById(R.id.b3);
                        B3.setText(TextB3);

                        String TextC3 = getString(R.string.option3C) + " ❌";
                        TextView C3 = findViewById(R.id.c3);
                        C3.setText(TextC3);

                        String TextD3 = getString(R.string.option3D) + " ✔️";
                        TextView D3 = findViewById(R.id.d3);
                        D3.setText(TextD3);

                        String TextA4 = getString(R.string.option4A) + " ✔️";
                        TextView A4 = findViewById(R.id.a4);
                        A4.setText(TextA4);

                        String TextB4 = getString(R.string.option4B) + " ✔️";
                        TextView B4 = findViewById(R.id.b4);
                        B4.setText(TextB4);

                        String TextC4 = getString(R.string.option4C) + " ✔️";
                        TextView C4 = findViewById(R.id.c4);
                        C4.setText(TextC4);

                        String TextD4 = getString(R.string.option4D) + " ❌";
                        TextView D4 = findViewById(R.id.d4);
                        D4.setText(TextD4);

                        String TextA5 = getString(R.string.option5A) + " ❌";
                        TextView A5 = findViewById(R.id.a5);
                        A5.setText(TextA5);

                        String TextB5 = getString(R.string.option5B) + " ✔️";
                        TextView B5 = findViewById(R.id.b5);
                        B5.setText(TextB5);

                        String TextC5 = getString(R.string.option5C) + " ❌";
                        TextView C5 = findViewById(R.id.c5);
                        C5.setText(TextC5);

                        String TextD5 = getString(R.string.option5D) + " ❌";
                        TextView D5 = findViewById(R.id.d5);
                        D5.setText(TextD5);

                        String TextA6 = getString(R.string.answerOf6);
                        EditText A6 = findViewById(R.id.answer_of_6);
                        A6.setText(TextA6);

                        String TextA7 = getString(R.string.option7A) + " ❌";
                        TextView A7 = findViewById(R.id.a7);
                        A7.setText(TextA7);

                        String TextB7 = getString(R.string.option7B) + " ❌";
                        TextView B7 = findViewById(R.id.b7);
                        B7.setText(TextB7);

                        String TextC7 = getString(R.string.option7C) + " ❌";
                        TextView C7 = findViewById(R.id.c7);
                        C7.setText(TextC7);

                        String TextD7 = getString(R.string.option7D) + " ✔️";
                        TextView D7 = findViewById(R.id.d7);
                        D7.setText(TextD7);
                    }
                });
                //Restarts Quiz by calling finish(); and startActivity(getIntent());
                builder.setNeutralButton("RESTART QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(getIntent());
                    }
                });
                //No option to continue quiz
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intentionally left blank.
                    }
                });
                builder.show();
            }
        });
    }

    //Saves user's response when screen orientation changes
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (score > 0) {
            outState.putInt("score", score);
        }
        outState.putString("Charles Babbage", answerOf6);
        outState.putBoolean("option1A", choosedA1);
        outState.putBoolean("option1B", choosedB1);
        outState.putBoolean("option1C", choosedC1);
        outState.putBoolean("option1D", choosedD1);
        outState.putBoolean("option2A", choosedA2);
        outState.putBoolean("option2B", choosedB2);
        outState.putBoolean("option2C", choosedC2);
        outState.putBoolean("option2D", choosedD2);
        outState.putBoolean("option3A", choosedA3);
        outState.putBoolean("option3B", choosedB3);
        outState.putBoolean("option3C", choosedC3);
        outState.putBoolean("option3D", choosedD3);
        outState.putBoolean("option4A", choosedA4);
        outState.putBoolean("option4B", choosedB4);
        outState.putBoolean("option4C", choosedC4);
        outState.putBoolean("option4D", choosedD4);
        outState.putBoolean("option5A", choosedA5);
        outState.putBoolean("option5B", choosedB5);
        outState.putBoolean("option5C", choosedC5);
        outState.putBoolean("option5D", choosedD5);
        outState.putBoolean("option7A", choosedA7);
        outState.putBoolean("option7B", choosedB7);
        outState.putBoolean("option7C", choosedC7);
        outState.putBoolean("option7D", choosedD7);
        super.onSaveInstanceState(outState);
    }

    //Restores user's response after orientation changes
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        answerOf6 = savedInstanceState.getString("Charles Babbage");
        score = savedInstanceState.getInt("score");
        choosedA1 = savedInstanceState.getBoolean("option1A");
        choosedB1 = savedInstanceState.getBoolean("option1B");
        choosedC1 = savedInstanceState.getBoolean("option1C");
        choosedD1 = savedInstanceState.getBoolean("option1D");
        choosedA2 = savedInstanceState.getBoolean("option2A");
        choosedB2 = savedInstanceState.getBoolean("option2B");
        choosedC2 = savedInstanceState.getBoolean("option2C");
        choosedD2 = savedInstanceState.getBoolean("option2D");
        choosedA3 = savedInstanceState.getBoolean("option3A");
        choosedB3 = savedInstanceState.getBoolean("option3B");
        choosedC3 = savedInstanceState.getBoolean("option3C");
        choosedD3 = savedInstanceState.getBoolean("option3D");
        choosedA4 = savedInstanceState.getBoolean("option4A");
        choosedB4 = savedInstanceState.getBoolean("option4B");
        choosedC4 = savedInstanceState.getBoolean("option4C");
        choosedD4 = savedInstanceState.getBoolean("option4D");
        choosedA5 = savedInstanceState.getBoolean("option5A");
        choosedB5 = savedInstanceState.getBoolean("option5B");
        choosedC5 = savedInstanceState.getBoolean("option5C");
        choosedD5 = savedInstanceState.getBoolean("option5D");
        choosedA7 = savedInstanceState.getBoolean("option7A");
        choosedB7 = savedInstanceState.getBoolean("option7B");
        choosedC7 = savedInstanceState.getBoolean("option7C");
        choosedD7 = savedInstanceState.getBoolean("option7D");
    }

    public void displayResult(int scoreText) {
        if(scoreText >= 5) Toast.makeText(this, "Well played. You got " + scoreText + "/7 Marks", Toast.LENGTH_SHORT).show();
        else if(scoreText > 2) Toast.makeText(this, "Not bad. You got " + scoreText + "/7", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "You got very less marks of " + scoreText + "/7", Toast.LENGTH_SHORT).show();
    }
}
