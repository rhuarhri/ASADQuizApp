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
        QuestionET.setText(questionManger.getQuestion());
        QuestionET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus)
                {
                    //save question
                    questionManger.setQuestion(QuestionET.getText().toString());
                }
            }
        });

        //add answers
        ABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "A";
                AnswerET.setText(questionManger.getAnswerA());
                isCorrectBTN.setChecked(questionManger.checkIfAnswerCorrect("A"));
            }
        });

        BBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "B";
                AnswerET.setText(questionManger.getAnswerB());
                isCorrectBTN.setChecked(questionManger.checkIfAnswerCorrect("B"));
            }
        });

        CBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "C";
                AnswerET.setText(questionManger.getAnswerC());
                isCorrectBTN.setChecked(questionManger.checkIfAnswerCorrect("C"));
            }
        });

        DBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastAnswerEdited = "D";
                AnswerET.setText(questionManger.getAnswerD());
                isCorrectBTN.setChecked(questionManger.checkIfAnswerCorrect("D"));
            }
        });

        AnswerET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(LastAnswerEdited == "A")
                    {
                        questionManger.setAnswerA(AnswerET.getText().toString(), isCorrectBTN.isChecked());
                    }
                    else if (LastAnswerEdited == "B") {
                        questionManger.setAnswerB(AnswerET.getText().toString(), isCorrectBTN.isChecked());
                    }
                    else if (LastAnswerEdited == "C")
                    {
                        questionManger.setAnswerC(AnswerET.getText().toString(), isCorrectBTN.isChecked());
                    }
                    else if(LastAnswerEdited == "D")
                    {
                        questionManger.setAnswerD(AnswerET.getText().toString(), isCorrectBTN.isChecked());
                    }
                }
            }
        });


        //save time
        AddTimeSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                questionManger.setQuestionDisplayTime(progress);
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
                String error = questionManger.saveQuestion();

                if (error != "")
                {
                    Toast.makeText(getApplicationContext(), "ERROR: " + error, Toast.LENGTH_LONG).show();
                }
                else{
                    Intent goToHomeScreen = new Intent(getApplicationContext(), LectureHomeActivity.class);
                    startActivity(goToHomeScreen);
                }
            }
        });
    }
}
