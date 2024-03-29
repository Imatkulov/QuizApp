package com.geektech.quizapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question{

 private String category;
 private String type;
 private String difficulty;
 private String question;
 @SerializedName("correct_answer")
 private String correctAnswer;
 @SerializedName("incorrect_answers")
 private List<String> incorrectAnswers;

 private int selectedAnswerPosition;

 private List<String> answers;

 public Question(String category, String type, String difficulty, String question, String correctAnswer, List<String> incorrectAnswers, int selectedAnswerPosition, List<String> answers) {
  this.category = category;
  this.type = type;
  this.difficulty = difficulty;
  this.question = question;
  this.correctAnswer = correctAnswer;
  this.incorrectAnswers = incorrectAnswers;
 }

 public String getCategory() {
  return category;
 }

 public void setCategory(String category) {
  this.category = category;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }

 public String getDifficulty() {
  return difficulty;
 }

 public void setDifficulty(String difficulty) {
  this.difficulty = difficulty;
 }

 public String getQuestion() {
  return question;
 }

 public void setQuestion(String question) {
  this.question = question;
 }

 public String getCorrectAnswer() {
  return correctAnswer;
 }

 public void setCorrectAnswer(String correctAnswer) {
  this.correctAnswer = correctAnswer;
 }

 public List<String> getIncorrectAnswers() {
  return incorrectAnswers;
 }

 public void setIncorrectAnswers(List<String> incorrectAnswers) {
  this.incorrectAnswers = incorrectAnswers;
 }

 public int getSelectedAnswerPosition() {
  return selectedAnswerPosition;
 }

 public void setSelectedAnswerPosition(int selectedAnswerPosition) {
  this.selectedAnswerPosition = selectedAnswerPosition;
 }

 public List<String> getAnswers() {
  return answers;
 }

 public void setAnswers(List<String> answers) {
  this.answers = answers;
 }
 @NonNull
 @Override
 public String toString() {
  return category + " " + question + " " + type + " " + difficulty;
 }
}
