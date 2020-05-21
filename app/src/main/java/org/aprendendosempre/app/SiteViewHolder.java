package org.aprendendosempre.app;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SiteViewHolder extends RecyclerView.ViewHolder{

    TextView mTitle;
    ImageView mImg;


    public SiteViewHolder(@NonNull View itemView) {
        super(itemView);

        mTitle = itemView.findViewById(R.id.title_card);
        mImg = itemView.findViewById(R.id.img_card);
    }


}