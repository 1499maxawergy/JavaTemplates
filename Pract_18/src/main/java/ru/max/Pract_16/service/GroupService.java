package ru.max.Pract_16.service;

import ru.max.Pract_16.entity.Group;

import java.util.List;

public interface GroupService {
    Group addGroup(String name);
    Group deleteGroup(String name);
    Group getByName(String name);
    List<Group> getAll();
}
