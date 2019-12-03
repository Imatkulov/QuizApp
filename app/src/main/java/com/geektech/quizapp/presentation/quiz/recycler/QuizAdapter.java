package com.geektech.quizapp.presentation.quiz.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp.R;
import com.geektech.quizapp.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {

    private List<Question> mQuestion = new ArrayList<>();
    private OnItemClickListener mListener;

    public QuizAdapter(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public void setQuestion(List<Question> question) {
        mQuestion.clear();
        mQuestion.addAll(question);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.onBind(mQuestion.get(position));
        Log.d("ololo", "onBindViewHolder: " + mQuestion.size());
    }
    @Override
    public int getItemCount() {
        return mQuestion.size();
    }

    public List<Question> getmQuestion() {
        return mQuestion;
    }
    public interface OnItemClickListener{
        void onAnswerClick(int questionPosition, int answerPosition);
    }
}
