package org.aprendendosempre.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.datami.smi.SdState;
import com.datami.smi.SdStateChangeListener;
import com.datami.smi.SmiResult;
import com.datami.smi.SmiSdk;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ConstraintLayout bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            String mySdkKey = getString(R.string.SDK_KEY); //Use the SDK API access key given by Datami.
            String myUserId = "";
            int sdIconId = R.drawable.ic_launcher_foreground;

//        List<String> exclusionDomains = new ArrayList<String>(2);
//        exclusionDomains.add("www.google.com");
//        exclusionDomains.add("www.google.com.br");
//        SmiSdk.initSponsoredData(mySdkKey, this, myUserId, sdIconId, false, exclusionDomains);
            SmiSdk.initSponsoredData(mySdkKey, this, myUserId, sdIconId, false);

            setContentView(R.layout.teste);


            loadFragment(new MainFragment());

            BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
            navigationView.setOnNavigationItemSelectedListener(this);

        } catch (Exception e) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle( getString(R.string.app_name) )
                    .setMessage("Error")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                        }
                    }).show();
        }
    }

    public void next(String link){
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("Link", link);
        startActivity(intent);
    }





//    private void setupLinks(){
//        bt1=findViewById(R.id.constraintLayout1);
//        bt2=findViewById(R.id.constraintLayout2);
//        bt3=findViewById(R.id.constraintLayout3);
//        bt4=findViewById(R.id.constraintLayout4);
//        bt5=findViewById(R.id.constraintLayout5);
//        bt6=findViewById(R.id.constraintLayout6);
//        bt7=findViewById(R.id.constraintLayout7);
//        bt8=findViewById(R.id.constraintLayout8);
//        bt9=findViewById(R.id.constraintLayout9);
//    }

//    @Override
//    public void onChange(SmiResult smiResult) {
//        if(smiResult.getSdState() == SdState.SD_AVAILABLE ||
//                smiResult.getSdState() == SdState.SD_NOT_AVAILABLE ||
//                smiResult.getSdState() == SdState.WIFI) {
//            bt1.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://aprendendosempre.org/");
//                }
//            });
//
//            bt2.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://www.aprendizap.com.br/");
//                }
//            });
//
//            bt3.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://app.arvoreeducacao.com.br/login?platform=arvore");
//                }
//            });
//
//            bt4.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("http://avamec.mec.gov.br/#/");
//                }
//            });
//
//            bt5.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://escoladigital.org.br/");
//                }
//            });
//
//            bt6.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://edu.google.com/intl/pt/products/classroom/?modal_active=none");
//                }
//            });
//
//            bt7.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://pt.khanacademy.org/");
//                }
//            });
//
//            bt8.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://www.kinedu.com/pt");
//                }
//            });
//
//            bt9.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    next("https://novaescola.org.br/");
//                }
//            });
//        }
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.page_home:
                fragment = new MainFragment();
                break;

            case R.id.page_about:{
                fragment = new AboutFragment();
                break;
            }
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}



