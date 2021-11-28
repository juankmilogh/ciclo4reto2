/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.reto2.Services;

import com.reto2.reto2.Model.Productos;
import com.reto2.reto2.Repository.ProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class ProductoServices {
   
    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> getAll() {
        return productosRepository.getAll();
    }

    public Optional<Productos> getProducto(int id) {
        return productosRepository.getProducto(id);
    }

    public Productos create(Productos accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return productosRepository.create(accesory);
        }
    }

    public Productos update(Productos accesory) {

        if (accesory.getId() != null) {
            Optional<Productos> accesoryDb = productosRepository.getProducto(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                productosRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getProducto(id).map(accesory -> {
            productosRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
