package com.mthree.Student.service;

import com.mthree.Student.model.Student;
import com.mthree.Student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    private final StudentRepository studentRepo;
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student newStudent) {
        return studentRepo.save(newStudent);
    }

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

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
