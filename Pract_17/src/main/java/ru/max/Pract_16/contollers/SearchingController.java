package ru.max.Pract_16.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchingController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/surname/{SName}")
    public String searchS(@PathVariable String SName){
        List<Student> studentList = studentRepository.findStudentByLastname(SName);
        if (studentList.size() == 0){
            return "Student(s) with this lastname not found";
        } else {
            return studentList.toString();
        }
    }

    @GetMapping("/name/{name}")
    public String searchN(@PathVariable String name){
        List<Student> studentList = studentRepository.findStudentByFirstname(name);
        if (studentList.size() == 0){
            return "Student(s) with this firstname not found";
        } else {
            return studentList.toString();
        }
    }

    @GetMapping("/middle/{Mname}")
    public String searchM(@PathVariable String Mname){
        List<Student> studentList = studentRepository.findStudentByMiddlename(Mname);
        if (studentList.size() == 0){
            return "Student(s) with this middlename not found";
        } else {
            return studentList.toString();
        }
    }
}
