package ru.max.Pract_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(String Firstname, String Middlename, String Lastname, Group group);
}
