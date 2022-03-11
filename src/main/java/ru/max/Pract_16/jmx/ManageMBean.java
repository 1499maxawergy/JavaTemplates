package ru.max.Pract_16.jmx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Component;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.service.impl.UserService;

@Component
@Slf4j
@ManagedResource(description = "Application for delete Entities")
public class ManageMBean {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;


    @ManagedOperation(description = "Delete all groups from DB")
    public void deleteGroups(){
        groupRepository.deleteAll(groupRepository.findAllBy());
        log.info("All groups deleted (JMX)");
    }

    @ManagedOperation(description = "Show all users from DB")
    public String showUsers(){
        log.info("All users introduced (JMX)");
        return userService.allUsers().toString();
    }

    @ManagedOperation(description = "Delete user by ID")
    public void deleteUser(int id){
        boolean success = userService.deleteUser(id);
        if (success){
            log.info("User " + id + " deleted");
        } else {
            throw new NotFoundException("User with id(" + id + ") not found");
        }

    }

}
