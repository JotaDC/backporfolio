/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.services;

import com.argentinaprograma.backend.exception.UserNotFoundException;
import com.argentinaprograma.backend.models.Dato;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.argentinaprograma.backend.repository.DatoRepo;

/**
 *
 * @author Javier
 */
@Service
@Transactional
public class DatoService {
    private final DatoRepo datoRepo;

    @Autowired
    public DatoService(DatoRepo datoRepo) {
        this.datoRepo = datoRepo;
    }
    
    public Dato agregarDato(Dato dato){
        return datoRepo.save(dato);
    }
    
    public List<Dato> buscarDatos(){
        return this.datoRepo.findAll();
    }
    
    public Dato editarDato(Dato dato){
        return datoRepo.save(dato);
    }
    
    public void borrarDato(Long id){
        datoRepo.deleteById(id);
    }
    
    public Dato buscarDatoPorId(Long id){
        return datoRepo.findById(id).orElseThrow(()->new UserNotFoundException("dato no encontrado"));
        
        
        
    }
}
