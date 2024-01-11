package com.ndkchatapp.converter;

import com.ndkchatapp.api.output.UserOutput;
import com.ndkchatapp.dto.UserDTO;
import com.ndkchatapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class UserConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO toDTO(User user) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPassword(user.getPassword());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setName(user.getName());
        userDTO.setBirthday(dateFormat.format(user.getBirthDay()));
        userDTO.setGender(user.getGender());
        return userDTO;
    }

    public UserOutput toOutput(User user) {
        UserOutput userOutput = new UserOutput();
        userOutput.setId(user.getId());
        userOutput.setPhoneNumber(user.getPhoneNumber());
        userOutput.setName(user.getName());
        userOutput.setAvatar(user.getAvatar());
        userOutput.setBirthday(user.getBirthDay());
        userOutput.setGender(user.getGender());
        return userOutput;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setAvatar(userDTO.getAvatar());
        user.setName(userDTO.getName());
        user.setBirthDay(userDTO.getBirthday());
        user.setGender(userDTO.getGender());
        return user;
    }

    public User toEntity(UserDTO userDTO, User user) {
        return null;
    }
}
