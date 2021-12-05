/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Repository;

import com.reto2.reto2.Model.Orders;
import com.reto2.reto2.interfaces.OrdersInterfaces;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class OrdersRepository {
    @Autowired
    private OrdersInterfaces ordersInterface;
    
    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersInterface.findAll();
    }

    public Optional<Orders> getOneOrder(int id) {
        return ordersInterface.findById(id);
    }

    public Orders createOrders(Orders orders) {
        return ordersInterface.save(orders);
    }

    public void updateOrders(Orders orders) {
        ordersInterface.save(orders);
    }

    public void deleteOrders(Orders orders) {
        ordersInterface.delete(orders);
    }
    
    public Optional<Orders> lastUserId(){
        return ordersInterface.findTopByOrderByIdDesc();
    }
    
    public List<Orders> findByZone(String zona) {
        return ordersInterface.findByZone(zona);
    }
    
}
