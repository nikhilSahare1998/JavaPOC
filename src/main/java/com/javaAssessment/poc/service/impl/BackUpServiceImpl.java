package com.javaAssessment.poc.service.impl;

import com.javaAssessment.poc.entity.user.User;
import com.javaAssessment.poc.entity.userbackup.UserBackup;
import com.javaAssessment.poc.repository.userbackup.UserBackupRepository;
import com.javaAssessment.poc.repository.userrepo.UserRepository;
import com.javaAssessment.poc.service.BackUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BackUpServiceImpl implements BackUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBackupRepository userBackupRepository;


    @Override
//    @Scheduled(cron = "2 * * * * *")
    public void userDataBackUp() {
        List<User> all = userRepository.findByActiveStatus("Active");
        List<UserBackup> backups = new ArrayList<>();
        for (User user : all) {
            UserBackup userBackup = new UserBackup();
            BeanUtils.copyProperties(user, userBackup);
            backups.add(userBackup);
        }
        userBackupRepository.saveAll(backups);
        all.stream().forEach(user -> log.info(user.getEmailID()));

    }
}
