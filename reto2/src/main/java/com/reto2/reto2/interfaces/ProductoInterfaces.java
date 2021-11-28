/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.interfaces;

import com.reto2.reto2.Model.Productos;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Manager
 */
public interface ProductoInterfaces extends MongoRepository<Productos, Integer> {
    
}
