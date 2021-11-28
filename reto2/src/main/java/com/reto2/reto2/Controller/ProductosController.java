/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Controller;

import com.reto2.reto2.Model.Productos;
import com.reto2.reto2.Services.ProductoServices;
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
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ProductosController {
    @Autowired
    private ProductoServices productoServices;
    
    @GetMapping("/all")
    public List<Productos> getAll() {
        return productoServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Productos> getProducto(@PathVariable("id") int id) {
        return productoServices.getProducto(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos create(@RequestBody Productos gadget) {
        return productoServices.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update(@RequestBody Productos gadget) {
        return productoServices.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return productoServices.delete(id);
    }
    
}
