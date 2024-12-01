package com.demo.test.model;

public class Categories {
    private int categories_id;
    private String categories_name;

    public Categories(int categories_id, String categories_name) {
        this.categories_id = categories_id;
        this.categories_name = categories_name;
    }

    public Categories(String categories_name) {
        this.categories_name = categories_name;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }
}
