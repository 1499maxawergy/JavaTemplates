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


@RestController
@RequestMapping("/add")
public class AddingController {

    @Autowired
    StudentRepository studentRepository;
	@Autowired
	GroupRepository groupRepository;

    @GetMapping("/group/{name}")
    public String add(@PathVariable String name){
		Group group = new Group(name);
		if (groupRepository.findByGroupname(group.getGroupname()).size() == 0){
			groupRepository.save(group);
			return "Group " + group.getGroupname() + " have been created";
		} else {
			return "Group with name " + group.getGroupname() + " already exists";
		}
	}

	@GetMapping("/{group}/{full}")
	public String addS(@PathVariable String full, @PathVariable String group){
		if (groupRepository.findByGroupname(group).size() == 0)
			return "Group with name " + group + " doesnt exist";
		else {
			String[] names = full.split("\\.");
			Student student = new Student(names[0], names[1], names[2]);
			student.setGroup(groupRepository.findByGroupname(group).get(0));
			studentRepository.save(student);
			return "Student saved";
		}
	}

}
