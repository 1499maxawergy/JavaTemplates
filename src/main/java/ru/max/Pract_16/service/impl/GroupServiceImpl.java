package ru.max.Pract_16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.service.GroupService;
import ru.max.Pract_16.service.mail.MailService;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private MailService mailService;

    @Override
    @Transactional
    public Group addGroup(String name) {
        log.info("Request for add group: " + name);
        Group group = new Group(name);
        if (groupRepository.findByGroupname(group.getGroupname()) == null){
            Group savedGroup = groupRepository.saveAndFlush(group);
            mailService.sendEmail("admin@maxawergy.ru", "Spring Boot Info", "Group " + name + " added");
            return savedGroup;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Group deleteGroup(String name) {
        log.info("Request for delete group: " + name);
        Group deletedGroup = getByName(name);
        if (deletedGroup != null){
            groupRepository.delete(deletedGroup);
            mailService.sendEmail("admin@maxawergy.ru", "Spring Boot Info", "Group " + name + " deleted");
            return deletedGroup;
        }
        return null;
    }

    @Override
    @Transactional
    public Group getByName(String name) {
        Group gotGroup = groupRepository.findByGroupname(name);
        log.info("Request for group: " + name);
        return gotGroup;
    }

    @Override
    @Transactional
    public List<Group> getAll() {
        List<Group> allGroups= groupRepository.findAllBy();
        log.info("Request for all groups");
        return allGroups;
    }

}
