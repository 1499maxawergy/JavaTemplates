package ru.max.Pract_16.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "group")
@Table(name="groups")
public class Group {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    private String groupname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Student> list = new HashSet<Student>();

    public Group() {
    }

    public Group(String groupname) {
        this.groupname = groupname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Set<Student> getList() {
        return list;
    }

    public void setList(Set<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                ", list=" + list +
                '}';
    }
}
