package ru.max.Pract_16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.service.GroupService;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group addGroup(String name) {
        log.info("Request for add group: " + name);
        Group group = new Group(name);
        if (groupRepository.findByGroupname(group.getGroupname()) == null){
            Group savedGroup = groupRepository.saveAndFlush(group);
            return savedGroup;
        } else {
            return null;
        }
    }

    @Override
    public Group deleteGroup(String name) {
        log.info("Request for delete group: " + name);
        Group deletedGroup = getByName(name);
        if (deletedGroup != null){
            groupRepository.delete(deletedGroup);
            return deletedGroup;
        }
        return null;
    }

    @Override
    public Group getByName(String name) {
        Group gotGroup = groupRepository.findByGroupname(name);
        log.info("Request for group: " + name);
        return gotGroup;
    }

    @Override
    public List<Group> getAll() {
        List<Group> allGroups= groupRepository.findAllBy();
        log.info("Request for all groups");
        return allGroups;
    }
}
