package com.rafyee.rafyee_rajiv.pstuprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Website extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        getSupportActionBar().hide();

        webView = findViewById(R.id.webview);

        webView.loadUrl("https://www.pstu.ac.bd/");
        webView.clearFormData();
        webView.clearHistory();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}