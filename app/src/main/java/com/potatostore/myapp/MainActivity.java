package com.potatostore.myapp;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

// [2026-02-06] Code ma bhar bhar ka comment use hona chayya.
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Naya WebView banana
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        
        // Is URL ko GitHub Actions automatic replace kar dega
        webView.loadUrl("https://your-website-link.com");
        
        setContentView(webView);
    }
}
