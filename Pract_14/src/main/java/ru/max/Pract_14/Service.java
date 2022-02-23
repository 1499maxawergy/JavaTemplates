package ru.max.Pract_14;

import java.util.ArrayList;
import java.util.Objects;

public class Service {
    public static ArrayList<Group> groups = new ArrayList<>();

    public synchronized static boolean delete(String name){
        if (groups == null)
            return false;
        for (Group group : groups){
            if (Objects.equals(group.getGroupName(), name)){
                groups.remove(group);
                return true;
            }
        }
        return false;
    }

    public synchronized static boolean add(Group temp){
        if (groups == null){
            groups.add(temp);
            return true;
        }
        for (Group group : groups){
            if (Objects.equals(group.getGroupName(), temp.getGroupName())){
                return false;
            }
        }
        groups.add(temp);
        return true;
    }

    public synchronized static Group find(String name){
        if (groups == null)
            return null;
        for (Group group : groups){
            if (Objects.equals(group.getGroupName(), name)){
                return group;
            }
        }
        return null;
    }
}
