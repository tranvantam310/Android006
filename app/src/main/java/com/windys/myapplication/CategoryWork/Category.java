package com.windys.myapplication.CategoryWork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("categoryID")
    @Expose
    public Integer categoryID;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("urlCategory")
    @Expose
    public String urlCategory;
    @SerializedName("type")
    @Expose
    public Integer type;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlCategory() {
        return urlCategory;
    }

    public void setUrlCategory(String urlCategory) {
        this.urlCategory = urlCategory;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}