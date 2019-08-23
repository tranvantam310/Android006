package com.windys.myapplication.CategoryWork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResult {

    @SerializedName("listCate")
    @Expose
    public List<Category> listCate = null;

}