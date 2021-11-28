/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Controller;

import com.reto2.reto2.Model.Users;
import com.reto2.reto2.Services.UsersServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manager
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UsersController {
    @Autowired
    private UsersServices usersServices;
    
    @GetMapping("/all")
    public List<Users> getAll(){
        return usersServices.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Users> getUser(@PathVariable("id") int id){
        return usersServices.getUser(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users user) {
        return usersServices.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Users update(@RequestBody Users user) {
        return usersServices.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return usersServices.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    public Users authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usersServices.authenticateUser(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return usersServices.emailExists(email);
    }
}
    

