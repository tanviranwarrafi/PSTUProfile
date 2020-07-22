package com.rafyee.rafyee_rajiv.pstuprofile.Developer;

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

import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class DeveloperWebview extends AppCompatActivity {

    private ImageView backButton;
    private WebView webView;
    private ProgressBar websiteProgressBar;
    TextView actionbar;

    private String actionbar_title, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_webview);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        actionbar_title = intent.getExtras().getString("actionbar_title");
        link = intent.getExtras().getString("link");

        backButton = findViewById(R.id.developerWebview_backButton);
        actionbar = findViewById(R.id.developerWebview_actionbarTitle);
        webView = findViewById(R.id.developerWebview_webview);
        websiteProgressBar = findViewById(R.id.developerWebview_progressBar);

        /*actionbar.setText(actionbar_title);*/

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
}