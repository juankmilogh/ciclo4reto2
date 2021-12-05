/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Services;

import com.reto2.reto2.Model.Orders;
import com.reto2.reto2.Repository.OrdersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class OrdersServices {
    @Autowired
    private OrdersRepository ordersRepository;
    
    public List<Orders> getAllOrders() {
        return ordersRepository.getAllOrders();
    }

    public Optional<Orders> getOneOrder(int id) {
        return ordersRepository.getOneOrder(id);
    }

    public Orders createOrders(Orders orders) {
        
        
        Optional<Orders> orderIdMaxima = ordersRepository.lastUserId();
        
        
        if (orders.getId() == null) {
            
            if (orderIdMaxima.isEmpty())
                orders.setId(1);
            
            else
                orders.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Orders> e = ordersRepository.getOneOrder(orders.getId());
        if (e.isEmpty()) {
            return ordersRepository.createOrders(orders);            
        }else{
            return orders;
        }        
    }

    public Orders updateOrders(Orders orders) {

        if (orders.getId() != null) {
            Optional<Orders> orderDb = ordersRepository.getOneOrder(orders.getId());
            if (!orderDb.isEmpty()) {
                if (orders.getStatus() != null) {
                    orderDb.get().setStatus(orders.getStatus());
                }
                ordersRepository.updateOrders(orderDb.get());
                return orderDb.get();
            } else {
                return orders;
            }
        } else {
            return orders;
        }
    }

    public boolean deleteOrders(int id) {
        Boolean aBoolean = getOneOrder(id).map(orders -> {
            ordersRepository.deleteOrders(orders);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
    public List<Orders> findByZone(String zona) {
        return ordersRepository.findByZone(zona);
    }
    
}
