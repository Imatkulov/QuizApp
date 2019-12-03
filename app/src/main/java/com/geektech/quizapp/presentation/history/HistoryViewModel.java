package com.geektech.quizapp.presentation.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp.App;
import com.geektech.quizapp.model.ShortQuizResult;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    LiveData<List<ShortQuizResult>> listLiveData = App.historyStorage.getAllShort();
}
