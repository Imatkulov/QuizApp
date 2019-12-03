package com.geektech.quizapp.presentation.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp.App;
import com.geektech.quizapp.core.SingleLiveEvent;
import com.geektech.quizapp.data.IQuizRepository;
import com.geektech.quizapp.data.history.HistoryStorage;
import com.geektech.quizapp.model.Question;
import com.geektech.quizapp.model.QuizResult;

import java.util.Date;
import java.util.List;

public class QuizViewModel  extends ViewModel {

    private IQuizRepository quizRepository = App.quizRepository;
    private HistoryStorage historyStorage = App.historyStorage;
    private List<Question> mQuestions;

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> openResultEvent = new SingleLiveEvent<>();

    private int getCorrectAnswersAmount() {
        int correctAnswers = 0;

        for (Question question : mQuestions) {
            Integer selectedAnswerPosition = question.getSelectedAnswerPosition();

            if (selectedAnswerPosition != null &&
                    selectedAnswerPosition >= 0 &&
                    question.getAnswers().get(selectedAnswerPosition)
                            .equals(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    private void finishQuiz() {
        QuizResult quizResult = new QuizResult(
                0,
                mQuestions,
                getCorrectAnswersAmount(),
                new Date(),
                mQuestions.get(0).getCategory(),
                mQuestions.get(0).getDifficulty()
                );

        int resultId = historyStorage.saveQuizResult(quizResult);

        finishEvent.call();
        openResultEvent.setValue(resultId);
    }

    void init(Integer amount, Integer categoryId, String difficulty) {
        quizRepository.getQuiz(amount, categoryId, difficulty, new IQuizRepository.OnQuizCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                if (result.size() !=0){
                    Log.d("ololo", "dddddddd: " + result);
                    mQuestions = result;
                    questions.setValue(mQuestions);
                    currentQuestionPosition.setValue(0);
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("ololo", "Error " + e.getMessage());
            }
        });
    }
    void onAnswerClick(int questionPosition, int answerPosition) {
        if (currentQuestionPosition.getValue() == null || mQuestions == null) {
            return;
        }
        Question question = mQuestions.get(questionPosition);

        question.setSelectedAnswerPosition(answerPosition);

        mQuestions.set(questionPosition, question);

        questions.setValue(mQuestions);

        if (questionPosition == mQuestions.size() - 1) {
            finishQuiz();
        } else {
            currentQuestionPosition.setValue(questionPosition + 1);
        }
    }
    void onBackPressed() {

        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            if (currentPosition == 0) {
                finishEvent.call();
            } else {
                currentQuestionPosition.setValue(currentPosition - 1);
            }
        }
    }
     void onSkipClick() {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            onAnswerClick(currentPosition, -1);
        }
    }
}
