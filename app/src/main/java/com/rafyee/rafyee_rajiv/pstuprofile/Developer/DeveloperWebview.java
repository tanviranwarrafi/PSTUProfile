package com.rafyee.rafyee_rajiv.pstuprofile.Developer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class DeveloperWebview extends AppCompatActivity {

    private WebView webView;
    private ProgressBar websiteProgressBar;
    private String actionbar_title, link;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_webview);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        actionbar_title = intent.getExtras().getString("actionbar_title");
        link = intent.getExtras().getString("link");

        webView = findViewById(R.id.developerWebview_webview);
        websiteProgressBar = findViewById(R.id.developerWebview_progressBar);

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
    }

    public void onBackPressed() {
        Intent intent = new Intent(DeveloperWebview.this, Developer.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}