package ru.max.Pract_16.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.repository.StudentRepository;
import ru.max.Pract_16.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Student> getByName(String name) {
        List<Student> studentList = studentRepository.findStudentByFirstname(name);
        return studentList;
    }

    @Override
    public List<Student> getBySurname(String surname) {
        List<Student> studentList = studentRepository.findStudentByLastname(surname);
        return studentList;
    }

    @Override
    public List<Student> getByMiddlename(String middle) {
        List<Student> studentList = studentRepository.findStudentByMiddlename(middle);
        return studentList;
    }

    @Override
    public Student getByAllStatements(String firstname, String middlename, String lastname, String groupname) {
        Group group = groupRepository.findByGroupname(groupname);
        if (group != null) {
            Student student = studentRepository.findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(firstname, middlename, lastname, group);
            return student;
        }
        return null;
    }

    @Override
    public Student addStudent(String groupname, String full) {
        Group group = groupRepository.findByGroupname(groupname);
        if (group != null){
            String[] names = full.split("\\.");

            if (names.length != 3)
                return null;

            Student student = getByAllStatements(names[0], names[1], names[2], groupname);
            if (student == null){
                student = new Student(names[0], names[1], names[2]);
                student.setGroup(group);
                student = studentRepository.save(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public Student deleteStudent(String groupname, String full) {
        String[] names = full.split("\\.");

        if (names.length != 3)
            return null;

        Student student = getByAllStatements(names[0], names[1], names[2], groupname);
        if (student != null){
            studentRepository.delete(student);
            return student;
        }
        return null;
    }
}
