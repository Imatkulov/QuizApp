package com.geektech.quizapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.geektech.quizapp.data.db.converters.QuestionsConverter;
import com.geektech.quizapp.data.db.converters.TimestampConverter;

import java.util.Date;
import java.util.List;

    @Entity(tableName = "quiz_result")
    public class QuizResult {
        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "questions")
        @TypeConverters({QuestionsConverter.class})
        private List<Question> questions;

        @ColumnInfo(name = "correct_answers")
        private int correctAnswers;

        @ColumnInfo(name = "created_at")
        @TypeConverters({TimestampConverter.class})
        private Date createdAt;

        @ColumnInfo(name = "category")
        private String category;

        @ColumnInfo(name = "difficulty")
        private String difficulty;

        public QuizResult(int id, List<Question> questions, int correctAnswers, Date createdAt, String category, String difficulty) {
            this.id = id;
            this.questions = questions;
            this.correctAnswers = correctAnswers;
            this.createdAt = createdAt;
            this.category = category;
            this.difficulty = difficulty;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }

        public int getCorrectAnswers() {
            return correctAnswers;
        }

        public void setCorrectAnswers(int correctAnswers) {
            this.correctAnswers = correctAnswers;
        }

        public String getCategory(){
            return category;
        }
        public void setCategory(){
            this.category = category;
        }

        public String getDifficulty(){
            return difficulty;
        }

        public void setDifficulty(){
            this.difficulty = difficulty;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
    }




