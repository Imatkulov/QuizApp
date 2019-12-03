package com.geektech.quizapp.presentation.settings;

import androidx.lifecycle.ViewModel;

import com.geektech.quizapp.App;
import com.geektech.quizapp.core.SingleLiveEvent;

public class SettingsViewModel extends ViewModel {

    SingleLiveEvent<Integer> deleteAllEvent = new SingleLiveEvent<>();

    public void clearHistory(){
        App.historyStorage.deleteAll();
    }

    // TODO: Implement the ViewModel
}
