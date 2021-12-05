/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.interfaces;

import com.reto2.reto2.Model.Orders;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Manager
 */
public interface OrdersInterfaces extends MongoRepository<Orders, Integer> {
    
    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String zone);
    
    
    @Query("{status: ?0}")
    List<Orders> findByStatus(final String status);
    
    
    Optional<Orders> findTopByOrderByIdDesc();
}
