package com.demo28;


import jakarta.validation.constraints.NotNull;

public class Student {


    private int id;
    private String first_name;
    private int age;
    private String email;

    public Student(int id, String first_name, int age, String email) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}