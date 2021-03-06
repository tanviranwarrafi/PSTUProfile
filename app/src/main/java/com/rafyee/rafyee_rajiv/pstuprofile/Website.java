package com.rafyee.rafyee_rajiv.pstuprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Website extends AppCompatActivity {

    private ImageView backButton;
    private WebView webView;
    private ProgressBar websiteProgressBar;
    private TextView actionbarTitle;

    private String actionbar_title, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        actionbar_title = intent.getExtras().getString("actionbar_title");
        link = intent.getExtras().getString("link");

        backButton = findViewById(R.id.website_backButton);
        actionbarTitle = findViewById(R.id.website_actionbar_title);
        webView = findViewById(R.id.webview);
        websiteProgressBar = findViewById(R.id.website_progressBar);

        actionbarTitle.setText(actionbar_title);

        websiteProgressBar.setProgress(100);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                websiteProgressBar.setProgress(newProgress);

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                websiteProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                websiteProgressBar.setVisibility(View.GONE);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Website.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Website.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}