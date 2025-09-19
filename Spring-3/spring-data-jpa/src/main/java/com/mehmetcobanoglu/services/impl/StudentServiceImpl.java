package com.mehmetcobanoglu.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcobanoglu.entities.Student;
import com.mehmetcobanoglu.repository.StudentRepository;
import com.mehmetcobanoglu.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;

    }

    @Override
    public void deleteStudent(Integer id) {
        Student dbStudent = getStudentById(id);
        if (dbStudent != null) {
            studentRepository.delete(dbStudent);

        }
    }
}
