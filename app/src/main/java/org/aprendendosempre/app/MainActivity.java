package org.aprendendosempre.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.datami.smi.SdState;
import com.datami.smi.SdStateChangeListener;
import com.datami.smi.SmiResult;
import com.datami.smi.SmiSdk;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements SdStateChangeListener {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    private BottomNavigationView navigationView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            // Call the Datami API at the beginning of onCreate, before other initializations.
            // IMPORTANT: If Datami API is not the first API called in the application then any network
            // connection made before Datami SDK initialization will be non-sponsored and will be
            // charged to the user.
            String mySdkKey = getString(R.string.SDK_KEY); //Use the SDK API access key given by Datami.
            String myUserId = "";
            int sdIconId = R.drawable.ic_launcher_foreground;

//        List<String> exclusionDomains = new ArrayList<String>(2);
//        exclusionDomains.add("www.google.com");
//        exclusionDomains.add("www.google.com.br");
//        SmiSdk.initSponsoredData(mySdkKey, this, myUserId, sdIconId, false, exclusionDomains);
            SmiSdk.initSponsoredData(mySdkKey, this, myUserId, sdIconId, false);

            setContentView(R.layout.activity);

            textView = findViewById(R.id.bottom_sheet_text_dice);

            textView.setText(HtmlCompat.fromHtml(getString(R.string.home_you), HtmlCompat.FROM_HTML_MODE_LEGACY));

            bt1=findViewById(R.id.button);
            bt2=findViewById(R.id.button2);
            bt3=findViewById(R.id.button3);
            bt4=findViewById(R.id.button4);
            bt5=findViewById(R.id.button5);
            bt6=findViewById(R.id.button6);
            bt7=findViewById(R.id.button7);
            bt8=findViewById(R.id.button8);
            bt9=findViewById(R.id.button9);

            bt1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://aprendendosempre.org/");
                }
            });

            bt2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://www.aprendizap.com.br/");
                }
            });

            bt3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://app.arvoreeducacao.com.br/login?platform=arvore");
                }
            });

            bt4.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("http://avamec.mec.gov.br/#/");
                }
            });

            bt5.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://escoladigital.org.br/");
                }
            });

            bt6.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://edu.google.com/intl/pt/products/classroom/?modal_active=none");
                }
            });

            bt7.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://pt.khanacademy.org/");
                }
            });

            bt8.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://www.kinedu.com/pt");
                }
            });

            bt9.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    next("https://novaescola.org.br/");
                }
            });

            navigationView = findViewById(R.id.bottom_navigation);

        }



        catch (Exception e)
        {

        }
    }

    public void next(String link){
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("Link", link);
        startActivity(intent);
    }


    @Override
    public void onChange(SmiResult smiResult) {
        if(smiResult.getSdState() == SdState.SD_AVAILABLE ||
                smiResult.getSdState() == SdState.SD_NOT_AVAILABLE ||
                smiResult.getSdState() == SdState.WIFI) {
            bt1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://aprendendosempre.org/");
                }
            });

            bt2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://www.aprendizap.com.br/");
                }
            });

            bt3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://app.arvoreeducacao.com.br/login?platform=arvore");
                }
            });

            bt4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("http://avamec.mec.gov.br/#/");
                }
            });

            bt5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://escoladigital.org.br/");
                }
            });

            bt6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://edu.google.com/intl/pt/products/classroom/?modal_active=none");
                }
            });

            bt7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://pt.khanacademy.org/");
                }
            });

            bt8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://www.kinedu.com/pt");
                }
            });

            bt9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next("https://novaescola.org.br/");
                }
            });
        }
    }

}


