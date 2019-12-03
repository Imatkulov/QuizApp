package com.geektech.quizapp.data.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.geektech.quizapp.model.QuizResult;
import com.geektech.quizapp.model.ShortQuizResult;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage  {
    private HistoryDao dao;

    public HistoryStorage(HistoryDao dao) {
        this.dao = dao;
    }


    public QuizResult getQuizResult(int id) {
        return dao.get(id);
    }

    public int saveQuizResult(QuizResult quizResult) {
        return (int) dao.insert(quizResult);
    }

    public LiveData<List<QuizResult>> getAll() {
        return dao.getAll();
    }

    public LiveData<List<ShortQuizResult>> getAllShort() {

        return Transformations.map(getAll(), quizResults -> {
            ArrayList<ShortQuizResult> shortQuizResults = new ArrayList<>();

            for (QuizResult quizResult : quizResults) {
                shortQuizResults.add(new ShortQuizResult(
                        quizResult.getId(),
                        quizResult.getQuestions().size(),
                        quizResult.getCorrectAnswers(),
                        quizResult.getQuestions().get(0).getCategory(),
                        quizResult.getQuestions().get(0).getDifficulty(),
                        quizResult.getCreatedAt()
                ));
            }

            return shortQuizResults;
        });
    }

    public int deleteAll() {
        return dao.deleteALL();

    }
}
