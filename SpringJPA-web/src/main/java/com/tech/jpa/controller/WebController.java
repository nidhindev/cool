package com.tech.jpa.controller;

import com.tech.jpa.domain.User;
import com.tech.jpa.persistance.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by x074823 on 8/15/2016.
 */
@RestController
public class WebController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public User createUser(@RequestParam(value="username", defaultValue="World") String username, @RequestParam(value="role", defaultValue="DEFAULT") String role) {
        User user = new User(username, role);
        com.tech.jpa.persistance.entity.User userDto = modelMapper.map(user, com.tech.jpa.persistance.entity.User.class);
        System.out.println("dto print :" +userDto);
        userRepository.save(userDto);
        return user;

    }

    @RequestMapping(value = "/getAuth", method = RequestMethod.GET)
    public User getAuth(@RequestParam(value="username") String username) {
        com.tech.jpa.persistance.entity.User userDTO = userRepository.findByUsername(username);
        User user = modelMapper.map(userDTO, User.class);
        System.out.println("User print :" +user);
        return user;
    }

}
