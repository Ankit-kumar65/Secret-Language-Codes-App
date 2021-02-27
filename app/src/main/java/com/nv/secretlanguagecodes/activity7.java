package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class activity7 extends AppCompatActivity {
    private Button b11;
    private Button b21;
    private AdView mAdView;
    private AdView mAdView1;
    private InterstitialAd mInterstitialAd;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity7);

        b11 = (Button) findViewById(R.id.vl);
        b21 = (Button) findViewById(R.id.ve);



        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }

            private void openactivity2() {
                Intent intent = new Intent(activity7.this, activity5.class);
                startActivity(intent);

            }


        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity3();

            }

            private void openactivity3() {
                Intent intent = new Intent(activity7.this, activity8.class);
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







    }
}
