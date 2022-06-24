package com.javaAssessment.poc.service.impl;

import com.javaAssessment.poc.dto.Mail;
import com.javaAssessment.poc.dto.UserDto;
import com.javaAssessment.poc.entity.User;
import com.javaAssessment.poc.exception.UserException;
import com.javaAssessment.poc.user.repository.UserRepository;
import com.javaAssessment.poc.service.MailSenderService;
import com.javaAssessment.poc.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSenderService mailService;


    @Override
    public UserDto createUser(UserDto userDto) {

        User dbUser = userRepository.findByEmailIDOrMobileNoOrPanCardOrAadharCard(userDto.getEmailID(), userDto.getMobileNo(), userDto.getPanCard(), userDto.getAadharCard());
        if (!Objects.isNull(dbUser)) {
            throw new UserException("email ID/Mobile Number / Pan Card / Aadhar card  is not unique", HttpStatus.NOT_FOUND);
        } else {

           // sendMail(userDto);
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
              entityToDto(userRepository.save(dtoTOEntity(userDto)));
            userDto.setPassword(userDto.getPassword());
            sendMail(userDto);
            return userDto;
        }

    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (Objects.nonNull(user)) {
            return entityToDto(user);
        } else {
            throw new UserException(String.format("User not found for given  id ", id), HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public UserDto findByPanCardOrAadharCard(String identityCard) {
        User byPanCardOrAadharCard = userRepository.findByPanCardOrAadharCard(Optional.ofNullable(identityCard), Optional.ofNullable(identityCard));
        if (Objects.nonNull(byPanCardOrAadharCard)) {
            return entityToDto(byPanCardOrAadharCard);
        } else {
            throw new UserException("User not found for Pan Card/ Aadhar Card", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public List<UserDto> findByStateOrCountry(String location) {
        List<User> users = userRepository.findByStateOrCountry(Optional.ofNullable(location), Optional.ofNullable(location));
        if (users.isEmpty()) {
            throw new UserException(String.format("User not found for State / Country ", location), HttpStatus.BAD_REQUEST);
        }

        return users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
    }

    private User dtoTOEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    private UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    private void sendMail(UserDto user) {
        Mail mail = new Mail();
        mail.setMailFrom("emailId");
        mail.setMailTo(user.getEmailID());
       // mail.setMailTo(mail.getMailTo());
        mail.setMailSubject("Subject");
        mail.setMailContent(String.format("Welcome \n Your username - %s or %s\nPassword - %s\n\nThanks",
                user.getEmailID(), user.getMobileNo(), user.getPassword()));
        mailService.sendEmail(mail);
    }

}