package com.geektech.quizapp.data.model;

import com.geektech.quizapp.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponse {
    @SerializedName("trivia_categories")
    List<Category> categories;
}
