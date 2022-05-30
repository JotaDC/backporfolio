/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.services;


import com.argentinaprograma.backend.exception.UserNotFoundException;
import com.argentinaprograma.backend.models.Experiencia;
import com.argentinaprograma.backend.models.Skill;
import com.argentinaprograma.backend.repository.ExperienciaRepo;
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
public class ExperienciaService {
    private final ExperienciaRepo experienciaRepo;
    
    @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo){
        this.experienciaRepo=experienciaRepo;
    }
    
    public Experiencia agregarExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    
    public List<Experiencia> buscarExperiencias(){
        return this.experienciaRepo.findAll();
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    
    public void borrarExperiencia(Long id){
        experienciaRepo.deleteById(id);
    }
    public Experiencia buscarExperienciaPorId(Long id){
        return experienciaRepo.findById(id).orElseThrow(()->new UserNotFoundException("experiencia no encontrado"));
        
        
        
    }
}
