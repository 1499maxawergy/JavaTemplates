package ru.max.Pract_16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.repository.StudentRepository;
import ru.max.Pract_16.service.StudentService;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Student> getByName(String name) {
        log.info("Request for student(s) with firstname: " + name);
        List<Student> studentList = studentRepository.findStudentByFirstname(name);
        return studentList;
    }

    @Override
    public List<Student> getBySurname(String surname) {
        log.info("Request for student(s) with lastname: " + surname);
        List<Student> studentList = studentRepository.findStudentByLastname(surname);
        return studentList;
    }

    @Override
    public List<Student> getByMiddlename(String middle) {
        log.info("Request for student(s) with middlename: " + middle);
        List<Student> studentList = studentRepository.findStudentByMiddlename(middle);
        return studentList;
    }

    @Override
    public Student getByAllStatements(String firstname, String middlename, String lastname, String groupname) {
        log.info("Request for getting student: | " + firstname +
                " | " + middlename + " | " + lastname + " | " + " in group: " + groupname);
        Group group = groupRepository.findByGroupname(groupname);
        if (group != null) {
            Student student = studentRepository
                    .findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(firstname, middlename, lastname, group);
            return student;
        }
        return null;
    }

    @Override
    public Student addStudent(String groupname, String full) {
        log.info("Request for add student: " + full + " to group: " + groupname);
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
        log.info("Request for delete student: " + full + " from group: " + groupname);
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
