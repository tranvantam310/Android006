package com.windys.myapplication.CategoryWork;

public class CategoryData {

    private int img_category;
    private String name;

    public int getImg_category() {
        return img_category;
    }

    public void setImg_category(int img_category) {
        this.img_category = img_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryData(int img_category, String name) {
        this.img_category = img_category;
        this.name = name;
    }
}
