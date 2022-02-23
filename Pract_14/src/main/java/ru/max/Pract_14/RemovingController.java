package ru.max.Pract_14;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/remove")
public class RemovingController {
    @GetMapping("/all")
    public String addGroup(){
        Service.groups = new ArrayList<>();
        System.out.println("All groups removed");
        return "All groups removed";
    }

    @GetMapping("/{nameG}")
    public String addStudent(@PathVariable String nameG){
        boolean check = Service.delete(nameG);
        if (check){
            System.out.println("Group " + nameG + " has been removed");
            return "Group " + nameG + " has been removed";
        } else {
            System.out.println("Group with name " + nameG + " not found");
            return "Group with name " + nameG + " not found";
        }
    }
}
