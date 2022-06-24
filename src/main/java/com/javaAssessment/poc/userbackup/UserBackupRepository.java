package com.javaAssessment.poc.userbackup;

import com.javaAssessment.poc.entity.UserBackup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBackupRepository extends MongoRepository<UserBackup,Long> {
}