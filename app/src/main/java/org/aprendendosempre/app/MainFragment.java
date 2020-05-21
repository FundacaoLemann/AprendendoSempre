package org.aprendendosempre.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {

    private ConstraintLayout bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        TextView textView = view.findViewById(R.id.bottom_sheet_text_dice);

        Button btn_home = view.findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://aprendendosempre.org/")));
            }
        });

        textView.setText(HtmlCompat.fromHtml(getString(R.string.home_you), HtmlCompat.FROM_HTML_MODE_LEGACY));

        setupLinks(view);

        return view;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private void setupLinks(View view){
        bt1= view.findViewById(R.id.constraintLayout1);
        bt2= view.findViewById(R.id.constraintLayout2);
        bt3= view.findViewById(R.id.constraintLayout3);
        bt4= view.findViewById(R.id.constraintLayout4);
        bt5= view.findViewById(R.id.constraintLayout5);
        bt6= view.findViewById(R.id.constraintLayout6);
        bt7= view.findViewById(R.id.constraintLayout7);
        bt8= view.findViewById(R.id.constraintLayout8);
        bt9= view.findViewById(R.id.constraintLayout9);



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
    }

    private void next(String link){
        Intent intent = new Intent(requireActivity(), WebViewActivity.class);
        intent.putExtra("Link", link);
        startActivity(intent);
    }
}
