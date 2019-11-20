package com.geektech.quizapp.presentation.quiz.recycler;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp.R;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;
    ProgressBar q_ProgressBar;
    TextView count_quiz;
    TextView question_field;

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.mTextView);
        q_ProgressBar = itemView.findViewById(R.id.q_ProgressBar);
        count_quiz = itemView.findViewById(R.id.count_quiz);
        question_field = itemView.findViewById(R.id.quiz_question_field);
    }
}
