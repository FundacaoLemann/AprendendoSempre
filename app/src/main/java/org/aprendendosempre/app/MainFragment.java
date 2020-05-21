package org.aprendendosempre.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    private RecyclerView recyclerView;

    private ConstraintLayout bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {
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


            recyclerView = view.findViewById(R.id.recycler_sites);

            Site site = new Site(getString(R.string.aprendendo), R.mipmap.aprendendo_sempre_logo, "https://aprendendosempre.org/");
            Site site1 = new Site(getString(R.string.aprendizap), R.mipmap.aprendizap_logo, "https://www.aprendizap.com.br/");
            Site site2 = new Site(getString(R.string.arvoveredu), R.mipmap.arvore_de_livros, "https://app.arvoreeducacao.com.br/login?platform=arvore");
            Site site3 = new Site(getString(R.string.avamec____), R.mipmap.avamec, "http://avamec.mec.gov.br/#/");
            Site site4 = new Site(getString(R.string.escoladigi), R.mipmap.escola_digital, "https://escoladigital.org.br/");
            Site site5 = new Site(getString(R.string.googlesala), R.mipmap.google_sala_de_aula, "https://edu.google.com/intl/pt/products/classroom/?modal_active=none");
            Site site6 = new Site(getString(R.string.khanacadem), R.mipmap.khan_academy, "https://pt.khanacademy.org/");
            Site site7 = new Site(getString(R.string.kinedu____), R.mipmap.kinedu, "https://www.kinedu.com/pt");
            Site site8 = new Site(getString(R.string.novaescola), R.mipmap.nova_escola, "https://novaescola.org.br/");


            List<Site> lista = new ArrayList<>(10);
            lista.add(0, site);
            lista.add(1, site1);
            lista.add(2, site2);
            lista.add(3, site3);
            lista.add(4, site4);
            lista.add(5, site5);
            lista.add(6, site6);
            lista.add(7, site7);
            lista.add(8, site8);

            
            SiteAdapter adapter = new SiteAdapter(lista, requireContext());

            recyclerView.setHasFixedSize(true);

            recyclerView.setAdapter(adapter);

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(requireContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);

            SearchView searchView = view.findViewById(R.id.searchView);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });


            return view;
        } catch (Exception e) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());
            dialog.setTitle(getString(R.string.app_name))
                    .setMessage("Error")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                        }
                    }).show();
            return null;
        }
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
