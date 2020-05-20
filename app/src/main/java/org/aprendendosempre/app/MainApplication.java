package org.aprendendosempre.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.datami.smi.*;

public class MainApplication extends Application implements SdStateChangeListener {
    private Toast toast;
    private Context context;
    private int duration;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        duration = Toast.LENGTH_LONG;
    }

    private static final String TAG = WebViewActivity.class.getName();
    public static SdState sdState;
    @Override
    public void onChange(SmiResult currentSmiResult) {
        sdState = currentSmiResult.getSdState();
        Log.d(TAG, "sponsored data state : "+sdState);
        CharSequence text = "";
        if(sdState == SdState.SD_AVAILABLE) {
            text = "Seu acesso a esse site é gratuito.";
        } else if(sdState == SdState.SD_NOT_AVAILABLE) {
            text = "Seu acesso a esse site poderá acarretar cobranças em seu plano de dados.";
            Log.d(TAG, " - reason: " + currentSmiResult.getSdReason());
        } else if(sdState == SdState.WIFI) {
            // device is in wifi
            text = "Acesso via wifi.";
            Log.d(TAG, "wifi - reason: " + currentSmiResult.getSdReason());
        }
        toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
