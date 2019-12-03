package com.geektech.quizapp;

import android.app.Application;

import androidx.room.Room;

import com.geektech.quizapp.data.IQuizRepository;
import com.geektech.quizapp.data.QuizRepository;
import com.geektech.quizapp.data.db.QuizDatabase;
import com.geektech.quizapp.data.history.HistoryStorage;

public class App extends Application {
    public static IQuizRepository quizRepository;
    public static QuizDatabase quizDatabase;
    public static HistoryStorage historyStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository();

        quizDatabase = Room.databaseBuilder(
                this,
                QuizDatabase.class,
                "quiz_db"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        historyStorage = new HistoryStorage(quizDatabase.getHistoryDao());
    }
}
