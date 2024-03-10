package com.demo28.dao;

import com.demo28.DB;
import com.demo28.Student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentDao{


    public StudentDaoImp() {
    }
@Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList();
    DB db = new DB();


        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from students");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirst_name(rs.getString("first_name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));

                list.add(student);
            }
        } catch (Exception var5) {
            System.out.println(var5);
        }

        return list;
    }
    @Override
    public void deleteStudent(Student student) {
        DB db = new DB();


        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from students where id=?");
            ps.setInt(1, student.getId());
            ps.executeUpdate();
        } catch (Exception var4) {
            System.out.println(var4);
        }

    }
    @Override
    public void addNewStudent(Student newStudent){
        DB db = new DB();


        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into students(id,first_name,age,email) values(?,?,?,?)");
            ps.setInt(1, newStudent.getId());
            ps.setString(2, newStudent.getFirst_name());
            ps.setInt(3, newStudent.getAge());
            ps.setString(4, newStudent.getEmail());

            ps.executeUpdate();

        } catch (Exception var4) {
            System.out.println(var4);
        }
    }
    @Override
    public void modifyStudent(Student student) {
        DB db = new DB();


        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("update students set id=?, first_name=?, age=?, email=? where id=?");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirst_name());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());

            ps.executeUpdate();
        } catch (Exception var4) {
            System.out.println(var4);
        }
    }
    @Override
    public Student getRecordById(int id) {
       Student student = null;
        DB db = new DB();


        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from students where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirst_name(rs.getString("first_name"));
                student.setAge(rs.getInt("age"));
                student.setFirst_name(rs.getString("email"));

            }
        } catch (Exception var5) {
            System.out.println(var5);
        }

        return student;
    }
    public List<Student> pagination(int pageNumber, int pageSize) {
        List<Student> list = new ArrayList();
        DB db = new DB();


        try {
            Connection con = db.getConnection();
            int startIndex = (pageNumber - 1) * pageSize; // Calculate the starting index for pagination
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students LIMIT ?, ?");
            ps.setInt(1, startIndex);
            ps.setInt(2, pageSize);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirst_name(rs.getString("first_name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));

                list.add(student);
            }
        } catch (Exception var5) {
            System.out.println(var5);
        }

        return list;
    }

}
