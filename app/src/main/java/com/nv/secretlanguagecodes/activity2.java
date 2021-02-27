package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.InterstitialAd;
public class activity2 extends AppCompatActivity {
    private Button b101;
    private Button b102;
    private Button b103;
    private AdView mAdView;
    private AdView mAdView1;
    private InterstitialAd mInterstitialAd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        b101 = (Button) findViewById(R.id.b55);
        b102 = (Button) findViewById(R.id.b66);
        b103 = (Button) findViewById(R.id.b103);
        b101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }

            private void openactivity2() {
                Intent intent = new Intent(activity2.this, activity1.class);
                startActivity(intent);

            } });

        b102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }

            private void openactivity2() {
                Intent intent = new Intent(activity2.this, activity3.class);
                startActivity(intent);

            } });


        b103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity4();

            }

            private void openactivity4() {
                Intent intent = new Intent(activity2.this, quiz11.class);
                startActivity(intent);

            } });











        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3617536878775410/8608442209");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        b103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(activity2.this,quiz11.class));
                }
                startActivity(new Intent(activity2.this,quiz11.class));


            }



        });






    }
}
