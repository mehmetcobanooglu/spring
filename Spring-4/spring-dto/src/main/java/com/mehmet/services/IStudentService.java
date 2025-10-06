package com.mehmet.services;

import java.util.List;

import com.mehmet.entities.Student;
import com.mehmet.dto.DtoStudent;
import com.mehmet.dto.DtoStudentIU;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
