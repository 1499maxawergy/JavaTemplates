package ru.max.Pract_16.service;

import ru.max.Pract_16.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getByName(String name);
    List<Student> getBySurname(String surname);
    List<Student> getByMiddlename(String middle);
    Student getByAllStatements(String firstname, String middlename, String lastname, String groupname);
    Student addStudent(String groupname, String full);
    Student deleteStudent(String groupname, String full);
}
