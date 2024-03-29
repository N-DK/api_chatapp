package com.ndkchatapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ndkchatapp.entities.User;
import com.ndkchatapp.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByPhoneNumber(username);
        if(null == user) {
            throw new UsernameNotFoundException("User Not Found with userName " + username);
        }
        return user;
    }

}
