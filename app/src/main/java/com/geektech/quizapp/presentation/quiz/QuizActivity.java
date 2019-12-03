package com.geektech.quizapp.presentation.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geektech.quizapp.R;
import com.geektech.quizapp.presentation.quiz.recycler.QuizAdapter;
import com.geektech.quizapp.presentation.result.ResultActivity;

public class QuizActivity extends AppCompatActivity implements QuizAdapter.OnItemClickListener{
    private QuizViewModel quizViewModel;

    private RecyclerView recyclerView_quiz;
    private QuizAdapter quizAdapter;


    private static String EXTRA_AMOUNT = "amount";
    private static String EXTRA_CATEGORY = "category";
    private static String EXTRA_DIFFICULTY = "difficulty";

    TextView category;
    ProgressBar progressBar;
    TextView countTextview;
    Button button;
    ImageView imageView;


    public static void start(Context context, int amount, int category, String difficulty) {
        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_CATEGORY, category);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        recyclerView_quiz = findViewById(R.id.recyclerView_quiz);
        quizAdapter = new QuizAdapter(this);
        recyclerView_quiz.setAdapter(quizAdapter);
        recyclerView_quiz.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false));
        recyclerView_quiz.setOnTouchListener((view, motionEvent) -> true);
        category = findViewById(R.id.mTextView1);
        progressBar = findViewById(R.id.q_ProgressBar);
        countTextview = findViewById(R.id.count_quiz);
        button = findViewById(R.id.quiz_skip);
        imageView = findViewById(R.id.image_btn);
        progressBar.setProgress(0);

        getData();
        initViewModel();
        onSkip();
        onBackPress();
    }


    private void getData() {
        Intent getIntent = getIntent();
        int amount = getIntent.getIntExtra(EXTRA_AMOUNT, 5);
        progressBar.setMax(amount);
        int id = getIntent.getIntExtra(EXTRA_CATEGORY, 0);


        String difficulty = getIntent.getStringExtra(EXTRA_DIFFICULTY).toLowerCase();
        if (difficulty.equals("any difficulty")){
            difficulty = null;
        }
        Log.d("--------", "getData: " + amount + " " + id + " "  + difficulty);
        quizViewModel.init(amount, id, difficulty);
    }
    private void onSkip(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizViewModel.onSkipClick();
            }
        });
    }

    private void onBackPress(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizViewModel.onBackPressed();
            }
        });
    }

    private void initViewModel() {
        quizViewModel.questions.observe(this, questions -> quizAdapter.setQuestion(questions));
        quizViewModel.openResultEvent.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                finish();
                ResultActivity.start(QuizActivity.this, integer);
            }
        });
        quizViewModel.currentQuestionPosition.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer position) {
                recyclerView_quiz.smoothScrollToPosition(position);
                category.setText(quizAdapter.getmQuestion().get(position).getCategory());
                progressBar.setProgress(position + 1);
                Log.d("ololo", "progress: " + position +1);
                countTextview.setText(position + 1 + "/" + quizAdapter.getItemCount());
            }
        });
    }

    @Override
    public void onAnswerClick(int questionPosition, int answerPosition) {
        quizViewModel.onAnswerClick(questionPosition, answerPosition);

    }
}
