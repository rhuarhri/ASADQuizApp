package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class studentAccessActivity extends AppCompatActivity {

    String QRInfo = "EVEKNRGGP35kYsxh1za8";
    Bitmap QRCode;

    ImageView quizIDQRDisplay;
    Button runBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_access);

        quizIDQRDisplay = (ImageView) findViewById(R.id.QuizIDQRIV);
        runBTN = (Button) findViewById(R.id.runQuizBTN);

        MultiFormatWriter testMFW = new MultiFormatWriter();
        try {
            BitMatrix TestBM = testMFW.encode(QRInfo, BarcodeFormat.QR_CODE, 800, 800);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            QRCode = barcodeEncoder.createBitmap(TestBM);

            quizIDQRDisplay.setImageBitmap(QRCode);

        } catch (WriterException e) {
            e.printStackTrace();
        }

        runBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLectureQuizManager = new Intent(getApplicationContext(), LectureQuizManagerActivity.class);

                goToLectureQuizManager.putExtra("id", QRInfo);

                startActivity(goToLectureQuizManager);
            }
        });
    }
}
