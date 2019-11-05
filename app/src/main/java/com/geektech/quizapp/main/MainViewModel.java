package com.geektech.quizapp.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData <String> title =  new MutableLiveData<>();

    public void init(){
        title.setValue("Main Activity Title");
        Log.d("Ololo", "ViewModel init: ");
    }

    public void changeTitle(){
        title.setValue("New title");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
