package com.ndkchatapp.api;

import com.ndkchatapp.api.output.UserOutput;
import com.ndkchatapp.api.output.UserTokenOutput;
import com.ndkchatapp.config.JWTTokenHelper;
import com.ndkchatapp.converter.UserConverter;
import com.ndkchatapp.dto.UserDTO;
import com.ndkchatapp.entities.User;
import com.ndkchatapp.repository.UserRepository;
import com.ndkchatapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

@RestController
@CrossOrigin(origins = {"*"})
public class UserAPI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/user/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDTO.getPhoneNumber(), userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        String jwtToken = jwtTokenHelper.generateToken(username);
        User user = userRepository.findOneByPhoneNumber(username);
        UserOutput userOutput = userConverter.toOutput(user);
        userOutput.setToken(jwtToken);
        return ResponseEntity.ok(userOutput);
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<?> register(@RequestBody UserDTO model) throws InvalidKeySpecException, NoSuchAlgorithmException {
        UserDTO userDTO = userService.save(model);
        return createToken(userDTO.getPhoneNumber());
    }

    @GetMapping("/api/user")
    public ResponseEntity<?> getUser(Principal user) {
        if (user == null)
            return null;
        User userObj = (User) userDetailsService.loadUserByUsername(user.getName());
        UserOutput userOutput = userConverter.toOutput(userObj);
        return ResponseEntity.ok(userOutput);
    }

    private ResponseEntity<?> createToken(String username) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String jwtToken = jwtTokenHelper.generateToken(username);
        UserTokenOutput response = new UserTokenOutput();
        response.setToken(jwtToken);
        return ResponseEntity.ok(response);
    }
}
