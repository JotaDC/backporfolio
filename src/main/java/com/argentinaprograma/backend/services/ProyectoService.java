/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.services;

import com.argentinaprograma.backend.exception.UserNotFoundException;
import com.argentinaprograma.backend.models.Proyecto;
import com.argentinaprograma.backend.repository.ProyectoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javier
 */
@Service
@Transactional
public class ProyectoService {
     private final ProyectoRepo proyectoRepo;
    
    @Autowired
    public ProyectoService(ProyectoRepo proyectoRepo){
        this.proyectoRepo=proyectoRepo;
    }
    
    public Proyecto agregarProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }
    
    public List<Proyecto> buscarProyectos(){
        return this.proyectoRepo.findAll();
    }
    
    public Proyecto editarProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }
    
    public void borrarProyecto(Long id){
        proyectoRepo.deleteById(id);
    }
    
     public Proyecto buscarProyectoPorId(Long id){
        return proyectoRepo.findById(id).orElseThrow(()->new UserNotFoundException("proyecto no encontrado")); 
    }
}
