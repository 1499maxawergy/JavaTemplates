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
@RequestMapping("/add")
public class AddingController {

    @Autowired
	StudentService studentService;
	@Autowired
	GroupService groupService;

    @GetMapping("/group/{name}")
    public String add(@PathVariable String name){
		Group group = groupService.addGroup(name);
		if (group != null){
			return "Group " + group.getGroupname() + " have been created";
		} else {
			return "Group with name " + name + " already exists";
		}
	}

	@GetMapping("/{group}/{full}")
	public String addS(@PathVariable String full, @PathVariable String group){
		Student student = studentService.addStudent(group, full);
		if (student != null){
			return "Student saved";
		} else
			return "Group with name " + group + " doesnt exist";
	}

}
