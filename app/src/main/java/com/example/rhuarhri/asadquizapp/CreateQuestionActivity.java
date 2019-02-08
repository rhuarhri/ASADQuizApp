package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Logiclayer.QuestionManger;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;

public class CreateQuestionActivity extends AppCompatActivity {

    EditText QuestionET;

    Button ABTN;
    Button BBTN;
    Button CBTN;
    Button DBTN;
    EditText AnswerET;
    CheckBox isCorrectBTN;

    TextView TimeDisplayTXT;
    SeekBar AddTimeSB;

    Button addImageBTN;
    Button saveQuestionBTN;

    QuestionManger questionManger;

    String LastAnswerEdited;

    question newQuestion = new question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);

        Intent quizData = getIntent();

        String QuizID = quizData.getStringExtra("ID").toString();

        questionManger = new QuestionManger(QuizID);

        QuestionET = (EditText) findViewById(R.id.QuestionET);

        ABTN = (Button) findViewById(R.id.AnswerABTN);
        BBTN = (Button) findViewById(R.id.AnswerBBTN);
        CBTN = (Button) findViewById(R.id.AnswerCBTN);
        DBTN = (Button) findViewById(R.id.AnswerDBTN);
        AnswerET = (EditText) findViewById(R.id.AnswerET);
        isCorrectBTN = (CheckBox) findViewById(R.id.IsCorrectBTN);

        TimeDisplayTXT = (TextView) findViewById(R.id.TimeTXT);
        AddTimeSB = (SeekBar) findViewById(R.id.TimeSB);

        addImageBTN = (Button) findViewById(R.id.AddImageBTN);
        saveQuestionBTN = (Button) findViewById(R.id.saveBTN);

        //add question code
        QuestionET.setText("");
        QuestionET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus)
                {
                    //save question
                    newQuestion.setQuestion(QuestionET.getText().toString());
                }
            }
        });

        //add answers
        ABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "A";
                AnswerET.setText(newQuestion.getAnswerA());
                if (newQuestion.getRightAnswer() == LastAnswerEdited)
                {
                    isCorrectBTN.setChecked(true);
                }
                else
                {
                    isCorrectBTN.setChecked(false);
                }

            }
        });

        BBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "B";
                AnswerET.setText(newQuestion.getAnswerB());
                if (newQuestion.getRightAnswer() == LastAnswerEdited) {
                    isCorrectBTN.setChecked(true);
                } else {
                    isCorrectBTN.setChecked(false);

                }
            }
        });

        CBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "C";
                AnswerET.setText(newQuestion.getAnswerC());
                if (newQuestion.getRightAnswer() == LastAnswerEdited) {
                    isCorrectBTN.setChecked(true);
                } else {
                    isCorrectBTN.setChecked(false);

                }
            }
        });

        DBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "D";
                AnswerET.setText(newQuestion.getAnswerD());
                if (newQuestion.getRightAnswer() == LastAnswerEdited) {
                    isCorrectBTN.setChecked(true);
                } else {
                    isCorrectBTN.setChecked(false);

                }
            }
        });

        AnswerET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(LastAnswerEdited == "A")
                    {
                        newQuestion.setAnswerA(AnswerET.getText().toString());
                        if (isCorrectBTN.isChecked() == true) {
                            newQuestion.setCorrectAnswer(true, false, false, false);
                        }
                    }
                    else if (LastAnswerEdited == "B") {
                        newQuestion.setAnswerB(AnswerET.getText().toString());
                        if (isCorrectBTN.isChecked() == true) {
                            newQuestion.setCorrectAnswer(false, true, false, false);
                        }
                    }
                    else if (LastAnswerEdited == "C")
                    {
                        newQuestion.setAnswerC(AnswerET.getText().toString());
                        if (isCorrectBTN.isChecked() == true) {
                            newQuestion.setCorrectAnswer(false, false, true, false);
                        }
                    }
                    else if(LastAnswerEdited == "D")
                    {
                        newQuestion.setAnswerD(AnswerET.getText().toString());
                        if (isCorrectBTN.isChecked() == true) {
                            newQuestion.setCorrectAnswer(false, false, false, true);
                        }
                    }
                }
            }
        });


        //save time
        AddTimeSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                newQuestion.setTime(progress);
                TimeDisplayTXT.setText("" + progress + " seconds");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //add image
        addImageBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        saveQuestionBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String error = questionManger.add(null, newQuestion, getApplicationContext());

                if (error != "")
                {
                    Toast.makeText(getApplicationContext(), "ERROR: " + error, Toast.LENGTH_LONG).show();
                }
                else{

                }
            }
        });
    }
}
