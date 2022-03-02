package ru.max.Pract_16.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.service.GroupService;
import ru.max.Pract_16.service.StudentService;


@RestController
@RequestMapping("/remove")
public class RemovingController {

    @Autowired
    StudentService studentService;
    @Autowired
    GroupService groupService;

    @GetMapping("/{group}")
    public String removeG(@PathVariable String group){
        Group deletedGroup = groupService.deleteGroup(group);
        if (deletedGroup == null)
            return "Group with name " + group + " doesnt exist";
        else {
            return "Group " + deletedGroup.getGroupname() + " deleted";
        }
    }

    @GetMapping("/{group}/{full}")
    public String removeS(@PathVariable String full, @PathVariable String group){
        Student student = studentService.deleteStudent(group, full);
        if (student != null){
            return "Student removed";
        } else {
            return "Group or student not found";
        }
    }
}
