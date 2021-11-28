/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Repository;

import com.reto2.reto2.Model.Productos;
import com.reto2.reto2.interfaces.ProductoInterfaces;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class ProductosRepository {
    @Autowired
    private ProductoInterfaces productoInterfaces;
    
    public List<Productos> getAll() {
        return (List<Productos>) productoInterfaces.findAll();
    }

     public Optional<Productos> getProducto(int id) {
        return productoInterfaces.findById(id);
    }

     public Productos create(Productos producto) {
        return productoInterfaces.save(producto);
    }

     public void update(Productos producto) {
        productoInterfaces.save(producto);
    }

      public void delete(Productos producto) {
        productoInterfaces.delete(producto);
    }

     
    
}
