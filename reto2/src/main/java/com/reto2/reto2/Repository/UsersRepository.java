/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Repository;

import com.reto2.reto2.Model.Users;
import com.reto2.reto2.interfaces.UsersInterfaces;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class UsersRepository {
    @Autowired
    private UsersInterfaces usersInterfaces;
    
    public List<Users> getAll() {
        return (List<Users>) usersInterfaces.findAll();
    }

     public Optional<Users> getUser(int id) {
        return usersInterfaces.findById(id);
    }

     public Users create(Users user) {
        return usersInterfaces.save(user);
    }

     public void update(Users user) {
        usersInterfaces.save(user);
    }

      public void delete(Users user) {
        usersInterfaces.delete(user);
    }

      public boolean emailExists(String email) {
        Optional<Users> usuario = usersInterfaces.findByEmail(email);
        
        return !usuario.isEmpty();
    }

      public Optional<Users> authenticateUser(String email, String password) {
        return usersInterfaces.findByEmailAndPassword(email, password);
    }

}
