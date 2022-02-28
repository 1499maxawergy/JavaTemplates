package ru.max.Pract_16.contollers;

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
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/{group}")
    public String showG(@PathVariable String group){
        if (groupRepository.findByGroupname(group).size() == 0)
            return "Group with name " + group + " doesnt exist";
        else {
            Group temp = groupRepository.findByGroupname(group).get(0);
            return temp.toString();
        }
    }

    @GetMapping("/all")
    public String showAll(){
        List<Group> groupList = groupRepository.findAllBy();
        return groupList.toString();
    }
}
