package com.geektech.quizapp.presentation.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.geektech.quizapp.R;
import com.geektech.quizapp.presentation.quiz.QuizActivity;

import org.angmarch.views.NiceSpinner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    SeekBar seek_bar;
    TextView questionAmount10;
    Button btnStart;
    NiceSpinner categorySpinner;
    NiceSpinner difficultySpinner;



    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        questionAmount10 = view.findViewById(R.id.questionAmount10);
        categorySpinner = view.findViewById(R.id.categorySpinner);
        difficultySpinner = view.findViewById(R.id.difficultySpinner);
        seek_bar = view.findViewById(R.id.seek_bar);
        btnStart = view.findViewById(R.id.btnStart);


        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                questionAmount10.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int categoryId = 0;
                if (categorySpinner.getSelectedIndex() != 0){
                    categoryId = categorySpinner.getSelectedIndex() + 8;
                }
            QuizActivity.start(getContext(),
                    seek_bar.getProgress(),
                    categoryId,
                    difficultySpinner.getSelectedItem().toString().toLowerCase());
            }
        });
    }

}
