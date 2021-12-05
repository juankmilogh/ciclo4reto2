/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Controller;

import com.reto2.reto2.Model.Orders;
import com.reto2.reto2.Services.OrdersServices;
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
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrdersController {
    
    @Autowired
    private OrdersServices ordersServices;
    
      @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersServices.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOneOrder(@PathVariable("id") int id) {
        return ordersServices.getOneOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders createOrders(@RequestBody Orders gadget) {
        return ordersServices.createOrders(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders updateOrders(@RequestBody Orders gadget) {
        return ordersServices.updateOrders(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return ordersServices.deleteOrders(id);
    }
    
    //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")
    public List<Orders> findByZone(@PathVariable("zona") String zona) {
        return ordersServices.findByZone(zona);
    }
    
}
