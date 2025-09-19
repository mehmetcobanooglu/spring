package com.mehmetcobanoglu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.mehmetcobanoglu.entities.Student;

public interface IStudentController {

    public Student saveStudent(@RequestBody Student student);

    public List<Student> getAllStudents();

    Student getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public Student updateStudent(Integer id, Student updateStudent);
}
