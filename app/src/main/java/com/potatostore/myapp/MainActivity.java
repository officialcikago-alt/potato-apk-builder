/*
 * ********************************************************************************
 * PROJECT: PotatoStore - Website to APK Converter
 * FILE: MainActivity.java
 * PURPOSE: Ye code website URL ko Android App ke andar full screen mein dikhayega.
 * DATE: 2026-02-06
 * [2026-02-06] Code ma bhar bhar ka comment use hona chayya - (Followed!)
 * ********************************************************************************
 */

package com.potatostore.myapp; // Bhai, ye package name Android setup ke liye zaruri hai

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // WebView ka variable declare kar rahe hain
    private WebView myPotatoWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* * Layout file ki jagah hum direct code se WebView bana rahe hain 
         * taaki tumhe XML ki zyada tension na ho.
         */
        myPotatoWebView = new WebView(this);
        
        // WebView ki settings handle karne ke liye
        WebSettings webSettings = myPotatoWebView.getSettings();
        
        // [IMPORTANT] JavaScript enable karna zaruri hai warna website sahi se nahi chalegi
        webSettings.setJavaScriptEnabled(true);
        
        // Website ko screen size ke hisaab se fit karne ke liye settings
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDomStorageEnabled(true); // Modern websites ke liye zaruri
        
        // Isse website app ke andar hi khulegi, browser mein nahi bhagegi
        myPotatoWebView.setWebViewClient(new WebViewClient());

        /* * YAHAN DHYAN DO BHAI: 
         * GitHub Action 'sed' command use karke is niche wale link ko 
         * tumhari website URL se replace kar dega.
         */
        myPotatoWebView.loadUrl("https://your-website-link.com");

        // Ab WebView ko screen par dikhao
        setContentView(myPotatoWebView);
    }

    /* * Agar user phone ka 'Back' button dabaye, toh app band hone ki jagah 
     * website ka pichla page khule (jaise Chrome mein hota hai).
     */
    @Override
    public void onBackPressed() {
        if (myPotatoWebView.canGoBack()) {
            myPotatoWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
