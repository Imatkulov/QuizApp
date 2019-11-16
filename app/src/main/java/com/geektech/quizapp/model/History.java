package com.geektech.quizapp.model;
import android.widget.ImageView;
import android.widget.TextView;


public class History {

    private TextView catTxtView;
    private TextView corTextView;
    private TextView difTexView;
    private ImageView hImageView;
    private TextView hDateTextView;


    public History(TextView catTxtView, TextView corTextView, TextView difTexView, ImageView hImageView, TextView hDateTextView) {
        this.catTxtView = catTxtView;
        this.corTextView = corTextView;
        this.difTexView = difTexView;
        this.hImageView = hImageView;
        this.hDateTextView = hDateTextView;
    }

    public TextView getCatTxtView() {
        return catTxtView;
    }

    public void setCatTxtView(TextView catTxtView) {
        this.catTxtView = catTxtView;
    }

    public TextView getCorTextView() {
        return corTextView;
    }

    public void setCorTextView(TextView corTextView) {
        this.corTextView = corTextView;
    }

    public TextView getDifTexView() {
        return difTexView;
    }

    public void setDifTexView(TextView difTexView) {
        this.difTexView = difTexView;
    }

    public ImageView gethImageView() {
        return hImageView;
    }

    public void sethImageView(ImageView hImageView) {
        this.hImageView = hImageView;
    }

    public TextView gethDateTextView() {
        return hDateTextView;
    }

    public void sethDateTextView(TextView hDateTextView) {
        this.hDateTextView = hDateTextView;
    }








}

