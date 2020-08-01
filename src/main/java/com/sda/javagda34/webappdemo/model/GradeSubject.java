package com.sda.javagda34.webappdemo.model;

public enum GradeSubject {
    ENGLISH("English"),
    POLISH("Polish"),
    IT("Information technology"),
    HISTORY("History"),
    MATH("Math");


    private String name;

    GradeSubject(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
