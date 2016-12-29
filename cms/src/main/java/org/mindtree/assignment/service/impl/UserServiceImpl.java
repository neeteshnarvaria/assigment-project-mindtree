package org.mindtree.assignment.service.impl;

import org.mindtree.assignment.models.User;
import org.mindtree.assignment.repositories.RoleRepository;
import org.mindtree.assignment.repositories.UserRepository;
import org.mindtree.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(userRepository.findAll().isEmpty()){
            user.setRole("ROLE_ADMIN");
        }else {
            user.setRole("ROLE_USER");
        }
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}