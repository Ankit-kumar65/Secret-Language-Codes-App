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


public class activity5 extends AppCompatActivity {
    private Button b11;
    private Button b21;
    private AdView mAdView;
    private AdView mAdView1;
    private InterstitialAd mInterstitialAd;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5);


        b11 = (Button) findViewById(R.id.ml);
        b21 = (Button) findViewById(R.id.me);

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }

            private void openactivity2() {
                Intent intent = new Intent(activity5.this, activity2.class);
                startActivity(intent);

            }


        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }

            private void openactivity2() {
                Intent intent = new Intent(activity5.this, morsecode.class);
                startActivity(intent);

            }


        });






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


        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(activity5.this,morsecode.class));
                }
                startActivity(new Intent(activity5.this,morsecode.class));


            }



        });








    }
}
