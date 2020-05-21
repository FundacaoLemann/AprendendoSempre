package org.aprendendosempre.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about, container, false);

        setupLinks(view);

        return view;
    }


    private void setupLinks(View view){

        ConstraintLayout btn1 = view.findViewById(R.id.mImage1);
        ConstraintLayout btn2 = view.findViewById(R.id.mImage2);
        ConstraintLayout btn3 = view.findViewById(R.id.mImage3);
        ConstraintLayout btn4 = view.findViewById(R.id.mImage4);
        ConstraintLayout btn5 = view.findViewById(R.id.mImage5);
        ConstraintLayout btn6 = view.findViewById(R.id.mImage6);
        ConstraintLayout btn7 = view.findViewById(R.id.mImage7);
        ConstraintLayout btn8 = view.findViewById(R.id.mImage8);
        ConstraintLayout btn9 = view.findViewById(R.id.mImage9);
        ConstraintLayout btn10 = view.findViewById(R.id.mImage10);
        ConstraintLayout btn11 = view.findViewById(R.id.mImage11);
        ConstraintLayout btn12 = view.findViewById(R.id.mImage12);
        ConstraintLayout btn13 = view.findViewById(R.id.mImage13);
        ConstraintLayout btn14 = view.findViewById(R.id.mImage14);
        ConstraintLayout btn15 = view.findViewById(R.id.mImage15);
        ConstraintLayout btn16 = view.findViewById(R.id.mImage16);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.iadb.org/pt")));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://movimentocolabora.org.br/")));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.consed.org.br/")));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.ensinabrasil.org/")));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.fundacaogrupoboticario.org.br/pt/")));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://frm.org.br/")));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.portaliede.com.br/")));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.institutoayrtonsenna.org.br/pt-br.html")));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://institutorodrigomendes.org.br/")));
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.institutovotorantim.org.br/")));
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://iungo.org.br/")));
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.ismart.org.br/")));
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://labedu.org.br/")));
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://movimentopelabase.org.br/")));
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://novaescola.org.br/")));
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://undime.org.br/")));
            }
        });

    }
}
