package com.geektech.quizapp.data;

import com.geektech.quizapp.model.Question;

import java.util.List;

public interface IQuizRepository {

    void getQuiz(OnQuizCallback callback);

    interface OnQuizCallback {
        void onSuccess(List<Question> questions);

        void onFailure(Exception e);
    }
}
