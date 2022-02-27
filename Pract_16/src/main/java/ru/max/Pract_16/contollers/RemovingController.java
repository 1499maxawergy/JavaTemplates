package ru.max.Pract_16.contollers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/remove")
public class RemovingController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/{group}")
    public String removeG(@PathVariable String group){
        if (groupRepository.findByGroupname(group).size() == 0)
            return "Group with name " + group + " doesnt exist";
        else {
            Group temp = groupRepository.findByGroupname(group).get(0);
            groupRepository.deleteById(temp.getId());
            return "Group " + temp.getGroupname() + " deleted";
        }
    }

    @GetMapping("/{group}/{full}")
    public String removeS(@PathVariable String full, @PathVariable String group){
        if (groupRepository.findByGroupname(group).size() == 0)
            return "Group with name " + group + " doesnt exist";
        else {
            Group temp = groupRepository.findByGroupname(group).get(0);
            String[] names = full.split("\\.");
            if (studentRepository.findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(names[0], names[1], names[2], temp).size() == 0)
                return "Student not found";
            else {
                Student student = studentRepository.findStudentByFirstnameAndMiddlenameAndLastnameAndGroup(names[0], names[1], names[2], temp).get(0);
                studentRepository.delete(student);
                return "Student removed";
            }
        }
    }

}
