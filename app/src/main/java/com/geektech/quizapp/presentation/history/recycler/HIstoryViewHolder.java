package com.geektech.quizapp.presentation.history.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp.R;

public class HIstoryViewHolder extends RecyclerView.ViewHolder {

    TextView catTxtView;
    TextView corTextView;
    TextView difTexView;
    ImageView hImageView;
    TextView hDateTextView;

    public HIstoryViewHolder(@NonNull View itemView) {
        super(itemView);
        catTxtView = itemView.findViewById(R.id.catTxtView);
        corTextView = itemView.findViewById(R.id.corTextView);
        difTexView = itemView.findViewById(R.id.difTexView);
        hImageView = itemView.findViewById(R.id.hImageView);
        hDateTextView = itemView.findViewById(R.id.hDateTextView);

    }
}
