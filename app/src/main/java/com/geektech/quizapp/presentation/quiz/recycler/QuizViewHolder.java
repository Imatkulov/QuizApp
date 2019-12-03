package com.geektech.quizapp.presentation.quiz.recycler;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp.R;
import com.geektech.quizapp.model.Question;


public class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private QuizAdapter.OnItemClickListener mListener;

    TextView mTextView;
    ProgressBar q_ProgressBar;
    TextView count_quiz;
    TextView quiz_question_field;
    TextView quiz_question_answer_1, quiz_question_answer_2,quiz_question_answer_3, quiz_question_answer_4;
    TextView textView1;
    TextView textView2;
    LinearLayout linearLayoutBoolean;
    LinearLayout linearLayoutMultiple;


    public QuizViewHolder(@NonNull View itemView, QuizAdapter.OnItemClickListener listener) {
        super(itemView);
        mListener = listener;
        mTextView = itemView.findViewById(R.id.quiz_question_field);
        q_ProgressBar = itemView.findViewById(R.id.q_ProgressBar);
        count_quiz = itemView.findViewById(R.id.count_quiz);
        quiz_question_field = itemView.findViewById(R.id.quiz_question_field);
        quiz_question_answer_1 = itemView.findViewById(R.id.quiz_question_answer_1);
        quiz_question_answer_2 = itemView.findViewById(R.id.quiz_question_answer_2);
        quiz_question_answer_3 = itemView.findViewById(R.id.quiz_question_answer_3);
        quiz_question_answer_4 = itemView.findViewById(R.id.quiz_question_answer_4);
        textView1 = itemView.findViewById(R.id.quiz_question_answer_1_1);
        textView2 = itemView.findViewById(R.id.quiz_question_answer_2_2);
        linearLayoutBoolean = itemView.findViewById(R.id.container_boolean);
        linearLayoutMultiple = itemView.findViewById(R.id.container_multiple);
        initClickListener();

    }

    private void initClickListener(){
        quiz_question_answer_1.setOnClickListener(this);
        quiz_question_answer_2.setOnClickListener(this);
        quiz_question_answer_3.setOnClickListener(this);
        quiz_question_answer_4.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public void onBind(Question question){
        mTextView.setText(Html.fromHtml(question.getQuestion()));
        if (question.getType().equals("multiple")){
            showMultipleQuestion(question);
            hideQuestionBoolean();
        } else {
            hideQuestionMultiple();
        }
        if (question.getType().equals("boolean")){
            if (question.getCorrectAnswer().equals("true")){
                textView1.setText("Yes");
            } else {
                textView2.setText("No");
            }
        }
    }

    private void hideQuestionBoolean(){
        linearLayoutBoolean.setVisibility(View.VISIBLE);
        linearLayoutMultiple.setVisibility(View.INVISIBLE);
    }
    private void hideQuestionMultiple(){
        linearLayoutBoolean.setVisibility(View.INVISIBLE);
        linearLayoutMultiple.setVisibility(View.VISIBLE);
    }
    private void showMultipleQuestion( Question question){
        quiz_question_answer_1.setText(Html.fromHtml(question.getAnswers().get(0)));
        quiz_question_answer_2.setText(Html.fromHtml(question.getAnswers().get(1)));
        quiz_question_answer_3.setText(Html.fromHtml(question.getAnswers().get(2)));
        quiz_question_answer_4.setText(Html.fromHtml(question.getAnswers().get(3)));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.quiz_question_answer_1:
            case R.id.quiz_question_answer_1_1:
                mListener.onAnswerClick(getAdapterPosition(),0);
                break;

            case R.id.quiz_question_answer_2:
            case R.id.quiz_question_answer_2_2:
                mListener.onAnswerClick(getAdapterPosition(),1);
                break;

            case R.id.quiz_question_answer_3:
                mListener.onAnswerClick(getAdapterPosition(),2);
                break;
            case R.id.quiz_question_answer_4:
                mListener.onAnswerClick(getAdapterPosition(),3);
                break;
        }
    }
}
