package ced.football.analysismoto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsWeb extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);
        web = findViewById(R.id.webView);
        showWeb();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void showWeb() {
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.getSettings().setDisplayZoomControls(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        String data = null;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            data = extras.getString("url");
        }
        web.loadUrl(data);
        web.setWebViewClient(new WebViewClient());
    }

    public void backClick(View view) {
        onBackPressed();
    }
}