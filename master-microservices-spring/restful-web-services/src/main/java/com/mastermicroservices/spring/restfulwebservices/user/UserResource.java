package com.mastermicroservices.spring.restfulwebservices.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    private UserDaoService service;

    @Autowired
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {

        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveOneUser(@PathVariable Integer id) {

        return service.getUser(id);
    }
}
