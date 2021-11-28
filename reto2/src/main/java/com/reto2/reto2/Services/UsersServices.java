/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Services;

import com.reto2.reto2.Model.Users;
import com.reto2.reto2.Repository.UsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class UsersServices {
    @Autowired
    private UsersRepository usersRepository;
    
    public List<Users> getAll() {
        return (List<Users>) usersRepository.getAll();
    }
    public Optional<Users> getUser(int id) {
        
        return usersRepository.getUser(id);
    }
    public Users create(Users user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<Users> e = usersRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return usersRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }

    public Users update(Users user) {

        if (user.getId() != null) {
            Optional<Users> userDb = usersRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                usersRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            usersRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public boolean emailExists(String email) {
        return usersRepository.emailExists(email);
    }

    public Users authenticateUser(String email, String password) {
        Optional<Users> usuario = usersRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new Users();
        } else {
            return usuario.get();
        }
    }
}
