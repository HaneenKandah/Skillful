package com.javaproject.skillful.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaproject.skillful.models.Tutor;
import com.javaproject.skillful.models.User;
import com.javaproject.skillful.repositories.RoleRepository;
import com.javaproject.skillful.repositories.TutorRepository;
import com.javaproject.skillful.repositories.UserRepository;

@Service
public class UserService {
    
	private UserRepository userRepository;
	private TutorRepository tutorRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    public UserService(UserRepository userRepository, TutorRepository tutorRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tutorRepository = tutorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }   
    
    public void saveUserWithTutorRole(Tutor tutor) {
        tutor.setPassword(bCryptPasswordEncoder.encode(tutor.getPassword()));
        tutor.setRoles(roleRepository.findByName("ROLE_TUTOR"));
        tutorRepository.save(tutor);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}