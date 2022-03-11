package ru.max.Pract_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(String Firstname, String Middlename, String Lastname, Group group);
    List<Student> findStudentByLastname(String Lastname);
    List<Student> findStudentByFirstname(String firstname);
    List<Student> findStudentByMiddlename(String middleName);

    @Modifying
    @Query(value = "COPY postgres.jpa.students " +
            "TO 'C:\\SpringBackups\\JavaT\\students.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveStudents();
}
