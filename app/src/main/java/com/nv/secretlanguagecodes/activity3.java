package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class activity3 extends AppCompatActivity {
    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        pdfView=findViewById(R.id.pdfView1);

        pdfView.fromAsset("combine.pdf")
                .load();




    }
}
