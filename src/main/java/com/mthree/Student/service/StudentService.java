package com.mthree.Student.service;

import com.mthree.Student.model.Student;

import java.util.List;

public interface StudentService {
    //read
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);

    //create
    public Student addStudent(Student newStudent);

    //update
    public Student updateStudent(Long id, Student updatedStudent);

    //delete
    public void deleteStudent(Long id);

}
