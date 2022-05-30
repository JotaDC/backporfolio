/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.services;


import com.argentinaprograma.backend.exception.UserNotFoundException;
import com.argentinaprograma.backend.models.Educacion;
import com.argentinaprograma.backend.models.Dato;
import com.argentinaprograma.backend.repository.EducacionRepo;
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
public class EducacionService {
    private final EducacionRepo educacionRepo;
    
    @Autowired
    public EducacionService(EducacionRepo educacionRepo){
        this.educacionRepo=educacionRepo;
    }
    
    public Educacion agregarEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public List<Educacion> buscarEducaciones(){
        return this.educacionRepo.findAll();
    }
    
    public Educacion editarEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    
     public Educacion buscarEducacionPorId(Long id){
        return educacionRepo.findById(id).orElseThrow(()->new UserNotFoundException("usuario no encontrado"));
        
        
        
    }
}
