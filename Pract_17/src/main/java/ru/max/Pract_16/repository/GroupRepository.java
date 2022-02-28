package ru.max.Pract_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.max.Pract_16.entity.Group;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByGroupname(String name);
    List<Group> findAllBy();
}
