package com.geektech.quizapp.presentation.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geektech.quizapp.R;

public class ResultActivity extends AppCompatActivity {

    private static String ID = "id";
    private ResultViewModel mResultViewModel;

    TextView r_catTexView;
    TextView result_all_text;
    TextView r_category_textView;
    TextView r_result;
    TextView r_result_percent;
    Button quiz_result_finish;
    TextView r_count;


    public static void start(Context context, Integer id){
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(ResultActivity.ID,id);
        context.startActivity(intent);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mResultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);

        r_category_textView = findViewById(R.id.r_category_textView);
        r_catTexView = findViewById(R.id.r_catTexView);
        result_all_text = findViewById(R.id.result_all_text);
        r_result = findViewById(R.id.r_result);
        r_count = findViewById(R.id.r_count);
        r_result_percent = findViewById(R.id.r_result_percent);
        quiz_result_finish = findViewById(R.id.quiz_result_finish);

        initResultViewModel();
        finishResult();
    }

    private void initResultViewModel(){
        mResultViewModel.getQuizResult(getIntent().getIntExtra(ID,0));
        mResultViewModel.quizResultMutableLiveData.observe(this,quizResult -> {
            r_catTexView.setText(quizResult.getQuestions().get(0).getCategory());
            result_all_text.setText(String.valueOf(quizResult.getQuestions().get(0).getDifficulty()));
            r_count.setText(quizResult.getCorrectAnswers() + "/" + quizResult.getQuestions().size());

            int stat = quizResult.getCorrectAnswers() * 100 / quizResult.getQuestions().size();
            r_result_percent.setText(stat + "%");

        });
    }
    private void finishResult(){
        quiz_result_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
