package com.geektech.quizapp.presentation.history.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp.R;
import com.geektech.quizapp.model.History;
import com.geektech.quizapp.model.ShortQuizResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HIstoryViewHolder> {

    private List<ShortQuizResult> mHistories = new ArrayList<>();



    public void setHistorie(List<ShortQuizResult> results) {
        mHistories.clear();
        mHistories.addAll(results);
        notifyDataSetChanged();
        Log.d("--------------", "setHistorie: "  + mHistories.size());
    }

    @NonNull
    @Override
    public HIstoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HIstoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HIstoryViewHolder holder, int position) {
            holder.catTxtView.setText("Category:" + " " + mHistories.get(position).getCategory());
            holder.corTextView.setText("Correct answers:" + " " + mHistories.get(position).getCorrectAnswers());
            holder.difTexView.setText("Difficulty:" + " " + mHistories.get(position).getDifficulty());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");
            holder.hDateTextView.setText (simpleDateFormat.format(mHistories.get(position).getCreatedAt()));
    }
    @Override
    public int getItemCount() {
        return mHistories.size();
    }
}
