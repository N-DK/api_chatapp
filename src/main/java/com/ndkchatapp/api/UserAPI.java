package com.ndkchatapp.api;

import com.ndkchatapp.dto.UserDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class UserAPI {

    @PostMapping("/api/user/login")
    public UserDTO login() {
        return null;
    }

    @PostMapping("/api/user/register")
    public UserDTO register() {
        return null;
    }
}
