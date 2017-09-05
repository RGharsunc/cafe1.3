package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUser(User user) {
        String password = user.getPassword();
        String f = new BCryptPasswordEncoder().encode(password);

        user.setPassword(f);
        userRepository.save(user);
    }

    public List<User> getUsersList(){
        return userRepository.findAll();
    }

    public List<User> getUsersListWereRoleIsWAITER(){
        return  userRepository.findByRole(Role.WAITER);
    }

    public User getUserById(long id){
        return  userRepository.findOne(id);
    }

}
