package ru.max.Pract_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.max.Pract_16.entity.Group;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByGroupname(String name);
    List<Group> findAllBy();

    @Modifying
    @Query(value = "COPY postgres.jpa.groups " +
            "TO 'C:\\SpringBackups\\JavaT\\groups.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveGroups();
}
