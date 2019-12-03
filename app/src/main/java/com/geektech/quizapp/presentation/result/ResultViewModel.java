package com.geektech.quizapp.presentation.result;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp.App;
import com.geektech.quizapp.model.QuizResult;

public class ResultViewModel extends ViewModel {

    public MutableLiveData<QuizResult> quizResultMutableLiveData = new MutableLiveData<>();

    public void getQuizResult(int id){
        QuizResult quizResult = App.historyStorage.getQuizResult(id);
        quizResultMutableLiveData.setValue(quizResult);
    }
}
