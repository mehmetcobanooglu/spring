package com.mehmet.controller;

import java.util.List;

import com.mehmet.entities.Student;
import com.mehmet.dto.DtoStudent;
import com.mehmet.dto.DtoStudentIU;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
