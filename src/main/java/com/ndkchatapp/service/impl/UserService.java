package com.ndkchatapp.service.impl;

import com.ndkchatapp.api.output.UserOutput;
import com.ndkchatapp.converter.UserConverter;
import com.ndkchatapp.dto.UserDTO;
import com.ndkchatapp.entities.User;
import com.ndkchatapp.repository.UserRepository;
import com.ndkchatapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserDTO save(UserDTO userDTO) {
        User user = userDTO.getId() != null
                ? userConverter.toEntity(userDTO, userRepository.findOneById(userDTO.getId()))
                : userConverter.toEntity(userDTO);
        userRepository.save(user);
        return userConverter.toDTO(user);
    }

    @Override
    public UserOutput findOneByPhoneNumber(String phoneNumber) {
        return userRepository.findOneByPhoneNumber(phoneNumber) != null
                ? userConverter.toOutput(userRepository.findOneByPhoneNumber(phoneNumber))
                : null;
    }

}
