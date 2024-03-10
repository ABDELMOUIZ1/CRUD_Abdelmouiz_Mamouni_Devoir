package com.demo28.dao;

import com.demo28.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    // Delete
    void deleteStudent(Student student);
    void addNewStudent(Student student);
    void modifyStudent(Student student);
    Student getRecordById(int id);
    List<Student> pagination(int pageNumber, int pageSize);
}