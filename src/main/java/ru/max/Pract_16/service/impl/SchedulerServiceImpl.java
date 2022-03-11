package ru.max.Pract_16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.max.Pract_16.repository.GroupRepository;
import ru.max.Pract_16.repository.StudentRepository;
import ru.max.Pract_16.repository.UserRepository;
import ru.max.Pract_16.service.SchedulerService;



@Service
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "* */30 * * * *")
    @Transactional
    @Override
    public void saveEntities() {
        studentRepository.saveStudents();
        groupRepository.saveGroups();
        userRepository.saveUsers();
        log.info("Entities saved");
    }
}
