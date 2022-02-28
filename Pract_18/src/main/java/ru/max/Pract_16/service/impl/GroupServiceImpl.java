package ru.max.Pract_16.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;


    @Override
    public Group addGroup(String name) {
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
        return gotGroup;
    }

    @Override
    public List<Group> getAll() {
        List<Group> allGroups= groupRepository.findAllBy();
        return allGroups;
    }
}
