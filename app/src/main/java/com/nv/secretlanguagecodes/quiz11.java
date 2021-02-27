package com.nv.secretlanguagecodes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;



public class quiz11 extends AppCompatActivity {
    private WebView mWebView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz11);
        mWebView = (WebView) findViewById(R.id.b34);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://quizlet.com/7375/test?answerTermSides=6&promptTermSides=6&questionCount=20&questionTypes=4&showImages=true");

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());









    }
}
