package ru.max.Pract_14;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/add")
public class AddingController {
    @GetMapping("/group/{name}")
    public String addGroup(@PathVariable String name){
        Group group = new Group(name);
        boolean check = Service.add(group);
        if (check){
            System.out.println("Group " + name + " created");
            return "Group " + group.getGroupName() + " has been created";
        } else {
            System.out.println("Group with this name already exists");
            return "Group with this name already exists";
        }
    }

    @GetMapping("/{nameG}/{full}")
    public String addStudent(@PathVariable String nameG, @PathVariable String full){
        Group group = Service.find(nameG);
        if (group == null){
            System.out.println("Group " + nameG + " not found");
            return "Group " + nameG + " not found";
        }
        String[] names = full.split("\\.");
        Student student = new Student(names[0], names[1], names[2]);
        group.addStudent(student);
        System.out.println("Student enters group" + group.getGroupName());
        return "Student enters group" + group.getGroupName();
    }
}
