package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class activity6 extends AppCompatActivity {
    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity6);

        pdfView=findViewById(R.id.pdfView2);

        pdfView.fromAsset("vpdf.pdf")
                .load();




    }
}
