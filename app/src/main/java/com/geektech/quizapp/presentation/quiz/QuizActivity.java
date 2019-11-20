package com.geektech.quizapp.presentation.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.geektech.quizapp.R;
import com.geektech.quizapp.presentation.quiz.recycler.QuizAdapter;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView recyclerView_quiz;
    private QuizAdapter quizAdapter;

    private static String EXTRA_AMOUNT = "amount";
    private static String EXTRA_CATEGORY = "category";
    private static String EXTRA_DIFFICULTY = "difficulty";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        recyclerView_quiz = findViewById(R.id.recyclerView_quiz);
        quizAdapter = new QuizAdapter();
        recyclerView_quiz.setAdapter(quizAdapter);
        recyclerView_quiz.setLayoutManager(new LinearLayoutManager(getBaseContext(),RecyclerView.HORIZONTAL, false));
    }
    public static void start(Context context, int amount, String category, String difficulty){
        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_CATEGORY, category);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        context.startActivity(intent);

    }
}
