package org.aprendendosempre.app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.datami.smi.SdState;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static androidx.core.app.NotificationCompat.getExtras;

public class WebViewActivity extends AppCompatActivity {

    WebView myWebView;
    Exception exception;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_web_view);

            String link = getIntent().getExtras().getString("Link");


            myWebView = new WebView(this);
            myWebView.setWebViewClient(new MyWebViewClient());
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            Locale.setDefault(new Locale("pt", "BR"));
            setContentView(myWebView);
            myWebView.loadUrl(link);
        }
        catch (Exception e)
        {
            exception = e;
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity_main)
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl(
                    "javascript:(function f() {" +
                    "var email = document.getElementsByName('identifier');" +
                    "email[0].oninput = function(value) {" +
                    "if(!/^\\w+([\\.-]?\\w+)*(@)?((e(d(u(c(a(d(o(r)?)?)?)?)?)?)?)?|(a(l(u(n(o)?)?)?)?))?(\\.)?(e(d(u(\\.(e(s(\\.(g(o(v(\\.(b(r)?)?)?)?)?)?)?)?)?)?)?)?)?$/.test(email[0].value)){" +
                    "email[0].value = '';" +
                    "email.parentNode.parentNode.parentNode.insertAdjacentHTML('afterend', 'Apenas domínio edu.es.gov.br!');" +
                    "return false;" +
                    "}" +
                    "}" +
                    "})()");
        }



        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            try {
                 if(url.startsWith("javascript"))
                     return false;

                if(MainApplication.sdState == SdState.SD_AVAILABLE)
                {
                    if (url.startsWith("http") || url.startsWith("https"))
                    {
                        URL urlEntrada = null;
                        urlEntrada = new URL(url);
                        List<String> urlsPermitidas = new ArrayList<String>(25);
                        urlsPermitidas.add("aprendendosempre.org/");
                        urlsPermitidas.add("www.aprendizap.com.br/");
                        urlsPermitidas.add("arvoreeducacao.com.br/");
                        urlsPermitidas.add("avamec.mec.gov.br/");
                        urlsPermitidas.add("escoladigital.org.br/");
                        urlsPermitidas.add("edu.google.com/");
                        urlsPermitidas.add("pt.khanacademy.org/");
                        urlsPermitidas.add("www.kinedu.com/pt");
                        urlsPermitidas.add("novaescola.org.br/");
                        urlsPermitidas.add("youtube.com/");

                        //TODO: fazer um filtro inteligente de URLs
                        for (int i = 0; i <= urlsPermitidas.size() -1; i++)
                        {
                            if(urlEntrada.getAuthority().contains(urlsPermitidas.get(i))) {
                                return false;
                            }
                        }
                        Log.d("ControleAcesso", "Acesso negado a " + url);
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(), "Acesso negado.", duration);
                        toast.show();
                        return true;
                    }
                    else
                        return false;
                }

                if (url.startsWith("intent://")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                        PackageManager packageManager = webView.getContext().getPackageManager();
                        if (intent != null) {
                            webView.stopLoading();
                            ResolveInfo info = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                            if (info != null) {
                                webView.getContext().startActivity(intent);
                            } else {
                                Intent marketIntent = new Intent(Intent.ACTION_VIEW).setData(
                                        Uri.parse("market://details?id=" + intent.getPackage()));
                                if (marketIntent.resolveActivity(packageManager) != null) {
                                    getApplicationContext().startActivity(marketIntent);
                                    return true;
                                }
                            }
                            return true;
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
            return true;
        }

    }
}


