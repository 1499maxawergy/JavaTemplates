package ru.max.Pract_14;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowingController {
    @GetMapping("/all")
    public String addGroup(){
        System.out.println("All groups show");
        return Service.groups.toString();
    }

    @GetMapping("/{nameG}")
    public String addStudent(@PathVariable String nameG){
        Group group = Service.find(nameG);
        if (group == null){
            System.out.println("Group " + nameG + " not found");
            return "Group " + nameG + " not found";
        }
        System.out.println("Group " + group.getGroupName() + " show");
        return group.toString();
    }
}
