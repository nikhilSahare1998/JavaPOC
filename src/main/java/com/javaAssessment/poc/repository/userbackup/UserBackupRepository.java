package com.javaAssessment.poc.repository.userbackup;

import com.javaAssessment.poc.entity.userbackup.UserBackup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserBackupRepository extends MongoRepository<UserBackup, Long> {
}
