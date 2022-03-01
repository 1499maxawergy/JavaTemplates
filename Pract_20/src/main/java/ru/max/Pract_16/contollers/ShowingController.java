package ru.max.Pract_16.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    GroupService groupService;

    @GetMapping("/{group}")
    public String showG(@PathVariable String group){
        Group showingGroup = groupService.getByName(group);
        if (showingGroup == null)
            return "Group with name " + group + " doesnt exist";
        else {
            return showingGroup.toString();
        }
    }

    @GetMapping("/all")
    public String showAll(){
        List<Group> groupList = groupService.getAll();
        if (groupList == null)
            return "Base is clear";
        else
            return groupList.toString();
    }
}
