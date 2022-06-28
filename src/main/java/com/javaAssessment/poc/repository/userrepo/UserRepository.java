package com.javaAssessment.poc.repository.userrepo;

import com.javaAssessment.poc.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIDOrMobileNo(String emailId, String mobileNo);
    User findByEmailIDOrMobileNoOrPanCardOrAadharCard(String emailId, String mobileNo, String panCard, String aadharCard);

    User findByPanCardOrAadharCard(Optional<String> panCard, Optional<String> aadharCard);

    List<User> findByStateOrCountry(Optional<String> state, Optional<String> country);

    List<User> findByActiveStatus(String status);

}
