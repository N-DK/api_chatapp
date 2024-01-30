package com.ndkchatapp.service;

import com.ndkchatapp.api.output.UserOutput;
import com.ndkchatapp.dto.UserDTO;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
    UserOutput findOneByPhoneNumber(String phoneNumber);
}
