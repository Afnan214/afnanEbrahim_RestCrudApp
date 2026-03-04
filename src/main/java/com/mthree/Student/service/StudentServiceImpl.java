package com.mthree.Student.service;

import com.mthree.Student.model.Student;
import com.mthree.Student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepo;

    //Constructor
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }


    //Get All Students service
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    //Get Student Bu Id
    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    //Create student
    @Override
    public Student addStudent(Student newStudent) {
        return studentRepo.save(newStudent);
    }

    //update row if found, else returns null
    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student stud = studentRepo.findById(id).orElse(null);
        if(stud!=null){
            stud.setName(updatedStudent.getName());
            stud.setFees(updatedStudent.getFees());
            stud.setSubjectName(updatedStudent.getSubjectName());
            return studentRepo.save(stud);
        }
        return null;
    }

    //delete student based on id
    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
