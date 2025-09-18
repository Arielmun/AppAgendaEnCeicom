package com.arielmondev.agendaescolar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SitioWeb extends AppCompatActivity {


    //DECLARO MIS VARIABLES //
    WebView wvSitioWeb;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sitio_web);

        wvSitioWeb =findViewById(R.id.wvSitioWeb);
        webSettings =wvSitioWeb.getSettings();

        //buen funcionamiento del SitioWeb java,dom
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        wvSitioWeb.loadUrl("https://institutoceicom.com/");
        wvSitioWeb.setWebViewClient(new WebViewClient());




    }
//    PARA QUE DENTRO EL SITIO WEB PUEDA NAVEGAR COMODAMENTE USANDO EL BACK
    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if (wvSitioWeb.canGoBack()){
            wvSitioWeb.goBack();
        }else {
            super.onBackPressed();
        }
    }
}