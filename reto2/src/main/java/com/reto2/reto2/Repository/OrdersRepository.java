/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Repository;

import com.reto2.reto2.Model.Orders;
import com.reto2.reto2.interfaces.OrdersInterfaces;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 *
 * @author Manager
 */
@Repository
public class OrdersRepository {
    @Autowired
    private OrdersInterfaces ordersInterface;
    
     @Autowired
    private MongoTemplate mongoTemplate;
    
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
    
    public List<Orders> ordersSalesManByID(Integer id) {
    Query query = new Query();
        
    Criteria criterio = Criteria.where("salesMan.id").is(id);
    query.addCriteria(criterio);
        
    List<Orders> orders = mongoTemplate.find(query, Orders.class);
        
    return orders;
        
 }

    public List<Orders> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                            .and("status").is(state);
        
        query.addCriteria(criterio);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;
    }
 

    public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
                        .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                        .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                        .and("salesMan.id").is(id);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;       
    }
    
}
