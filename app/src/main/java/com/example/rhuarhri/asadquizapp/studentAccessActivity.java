package com.example.rhuarhri.asadquizapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class studentAccessActivity extends AppCompatActivity {

    String QRInfo = "1";
    Bitmap QRCode;

    ImageView quizIDQRDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_access);

        quizIDQRDisplay = (ImageView) findViewById(R.id.QuizIDQRIV);

        MultiFormatWriter testMFW = new MultiFormatWriter();
        try {
            BitMatrix TestBM = testMFW.encode(QRInfo, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            QRCode = barcodeEncoder.createBitmap(TestBM);

            quizIDQRDisplay.setImageBitmap(QRCode);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
